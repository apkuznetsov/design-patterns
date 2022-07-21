package kuznetsov.decorator.coffee.concrete_components;

import kuznetsov.decorator.coffee.abstract_components.Beverage;

public class DarkRoast extends Beverage {

    public DarkRoast() {
        description = "Dark Roast Coffee";
    }

    public double cost() {
        return .99;
    }
}

