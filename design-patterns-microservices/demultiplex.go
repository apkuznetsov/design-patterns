package design_patterns_microservices

func Demultiplex(source <-chan int, destinationNum int) []<-chan int {
	destinations := make([]<-chan int, 0)

	for i := 0; i < destinationNum; i++ {
		ch := make(chan int)
		destinations = append(destinations, ch)
		go func() {
			defer close(ch)
			for msg := range source {
				ch <- msg
			}
		}()
	}

	return destinations
}
