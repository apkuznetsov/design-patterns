package design_patterns_microservices

import "context"

type Effector func(context.Context) (string, error)
