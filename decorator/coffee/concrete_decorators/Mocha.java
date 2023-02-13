package kuznetsov.decorator.coffee.concrete_decorators;

import kuznetsov.decorator.coffee.abstract_components.Beverage;
import kuznetsov.decorator.coffee.abstract_components.CondimentDecorator;

public class Mocha extends CondimentDecorator {

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    public double cost() {
        return beverage.cost() + .20;
    }
}
