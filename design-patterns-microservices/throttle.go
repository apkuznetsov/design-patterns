package design_patterns_microservices

import (
	"context"
	"fmt"
	"sync"
	"time"
)

func Throttle(effector Effector, maxTriesLeft uint, resetNum uint, resettingInterval time.Duration) Effector {
	var triesLeftCounter = maxTriesLeft

	var once sync.Once
	var mutex sync.Mutex

	return func(ctx context.Context) (string, error) {
		if ctx.Err() != nil {
			return "", ctx.Err()
		}

		once.Do(func() {
			ticker := time.NewTicker(resettingInterval)

			go func() {
				defer ticker.Stop()

				for {
					select {
					case <-ctx.Done():
						return

					case <-ticker.C:
						mutex.Lock()

						resetTriesLeft := triesLeftCounter + resetNum
						if resetTriesLeft > maxTriesLeft {
							resetTriesLeft = maxTriesLeft
						}

						triesLeftCounter = resetTriesLeft

						mutex.Unlock()
					}
				}
			}()
		})

		mutex.Lock()
		defer mutex.Unlock()

		if triesLeftCounter <= 0 {
			return "", fmt.Errorf("too many requests")
		}

		triesLeftCounter--

		return effector(ctx)
	}
}
