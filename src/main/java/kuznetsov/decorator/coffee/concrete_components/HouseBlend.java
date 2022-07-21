package kuznetsov.decorator.coffee.concrete_components;

import kuznetsov.decorator.coffee.abstract_components.Beverage;

public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "House Blend Coffee";
    }

    public double cost() {
        return .89;
    }
}
