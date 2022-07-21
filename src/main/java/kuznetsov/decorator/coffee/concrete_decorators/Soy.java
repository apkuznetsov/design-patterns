package kuznetsov.decorator.coffee.concrete_decorators;

import kuznetsov.decorator.coffee.abstract_components.Beverage;
import kuznetsov.decorator.coffee.abstract_components.CondimentDecorator;

public class Soy extends CondimentDecorator {

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    public double cost() {
        return .15 + beverage.cost();
    }
}
