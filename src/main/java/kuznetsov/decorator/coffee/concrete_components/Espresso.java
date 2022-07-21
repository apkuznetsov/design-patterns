package kuznetsov.decorator.coffee.concrete_components;

import kuznetsov.decorator.coffee.abstract_components.Beverage;

public class Espresso extends Beverage {

    public Espresso() {
        description = "Espresso";
    }

    public double cost() {
        return 1.99;
    }
}
