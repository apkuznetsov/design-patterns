package design_patterns_microservices

import (
	"context"
	"sync"
	"time"
)

type Future interface {
	Get() (string, error)
}

type FutureHelper struct {
	once sync.Once
	wg   sync.WaitGroup

	resCh <-chan string
	errCh <-chan error

	res string
	err error
}

func (f *FutureHelper) Get() (string, error) {
	f.once.Do(func() {
		f.wg.Add(1)
		defer f.wg.Done()

		f.res = <-f.resCh
		f.err = <-f.errCh
	})

	f.wg.Wait()

	return f.res, f.err
}

func FuncWithFuture(ctx context.Context) Future {
	resCh := make(chan string)
	errCh := make(chan error)

	go func() {
		select {
		case <-time.After(time.Second * 2):
			resCh <- "slept"
			errCh <- nil
		case <-ctx.Done():
			resCh <- ""
			errCh <- ctx.Err()
		}
	}()

	return &FutureHelper{resCh: resCh, errCh: errCh}
}
