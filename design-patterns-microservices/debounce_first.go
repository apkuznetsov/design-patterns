package design_patterns_microservices

import (
	"context"
	"sync"
	"time"
)

func DebounceFirst(circuit Circuit, d time.Duration) Circuit {
	var result string
	var err error
	var thresholdAt time.Time

	var mutex sync.Mutex

	return func(ctx context.Context) (string, error) {
		mutex.Lock()

		defer func() {
			thresholdAt = time.Now().Add(d)
			mutex.Unlock()
		}()

		isThresholdExceeded := time.Now().Before(thresholdAt)
		if isThresholdExceeded {
			return result, err
		}

		result, err = circuit(ctx)

		return result, err
	}
}
