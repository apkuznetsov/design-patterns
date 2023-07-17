package design_patterns_microservices

import (
	"context"
	"errors"
	"sync"
	"time"
)

type Circuit func(context.Context) (string, error)

func Breaker(circuit Circuit, failureThreshold uint) Circuit {
	var failureCounter = 0
	var lastAttemptAt = time.Now()
	var mutex sync.RWMutex

	return func(ctx context.Context) (string, error) {
		mutex.RLock()

		exceededAttemptsNumber := failureCounter - int(failureThreshold)
		isLimitExceeded := exceededAttemptsNumber >= 0

		if isLimitExceeded {
			timeoutIncrement := time.Second * 2 << exceededAttemptsNumber
			shouldRetryAt := lastAttemptAt.Add(timeoutIncrement)
			isTimeoutExceeded := !time.Now().After(shouldRetryAt)

			if isTimeoutExceeded {
				mutex.RUnlock()
				return "", errors.New("service unreachable")
			}
		}

		mutex.RUnlock()

		response, err := circuit(ctx)

		mutex.Lock()
		defer mutex.Unlock()

		lastAttemptAt = time.Now()

		if err != nil {
			failureCounter++
			return response, err
		}

		failureCounter = 0

		return response, nil
	}
}
