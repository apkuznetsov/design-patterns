package design_patterns_microservices

import (
	"context"
	"sync"
	"time"
)

func DebounceLast(circuit Circuit, duration time.Duration) Circuit {
	var result string
	var err error

	var thresholdAt = time.Now()
	var ticker *time.Ticker

	var once sync.Once
	var mutex sync.Mutex

	return func(ctx context.Context) (string, error) {
		mutex.Lock()
		defer mutex.Unlock()

		thresholdAt = time.Now().Add(duration)

		once.Do(func() {
			ticker = time.NewTicker(time.Millisecond * 100)

			go func() {
				defer func() {
					mutex.Lock()
					ticker.Stop()
					once = sync.Once{}
					mutex.Unlock()
				}()

				for {
					select {

					case <-ticker.C:
						mutex.Lock()
						isItTime := time.Now().After(thresholdAt)
						if isItTime {
							result, err = circuit(ctx)
							mutex.Unlock()
							return
						}
						mutex.Unlock()

					case <-ctx.Done():
						mutex.Lock()
						result, err = "", ctx.Err()
						mutex.Unlock()
						return
					}
				}
			}()

		})

		return result, err
	}
}
