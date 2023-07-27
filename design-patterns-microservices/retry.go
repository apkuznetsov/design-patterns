package design_patterns_microservices

import (
	"context"
	"time"
)

func Retry(effector Effector, maxRetriesNum int, delay time.Duration) Effector {
	return func(ctx context.Context) (string, error) {
		for i := 0; ; i++ {
			response, err := effector(ctx)
			if err == nil || i >= maxRetriesNum {
				return response, err
			}

			select {
			case <-time.After(delay):
			case <-ctx.Done():
				return "", ctx.Err()
			}
		}
	}
}
