package design_patterns_microservices

import "sync"

func Multiplex(sources ...<-chan int) <-chan int {
	destination := make(chan int)

	var wg sync.WaitGroup
	wg.Add(len(sources))

	for _, source := range sources {
		go func(ch <-chan int) {
			defer wg.Done()
			for msg := range ch {
				destination <- msg
			}
		}(source)
	}

	go func() {
		wg.Wait()
		close(destination)
	}()

	return destination
}
