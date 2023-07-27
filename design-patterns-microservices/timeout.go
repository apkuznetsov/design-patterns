package design_patterns_microservices

import "context"

type SomeFunc func(string) (string, error)

type FuncWithContext func(context.Context, string) (string, error)

func Timeout(f SomeFunc) FuncWithContext {
	return func(ctx context.Context, arg string) (string, error) {
		resCh := make(chan string)
		errCh := make(chan error)

		go func() {
			res, err := f(arg)
			resCh <- res
			errCh <- err
		}()

		select {
		case res := <-resCh:
			return res, <-errCh
		case <-ctx.Done():
			return "", ctx.Err()
		}
	}
}
