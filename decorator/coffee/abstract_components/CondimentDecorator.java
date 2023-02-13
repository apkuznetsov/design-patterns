package kuznetsov.decorator.coffee.abstract_components;

public abstract class CondimentDecorator extends Beverage {

    protected Beverage beverage;

    public abstract String getDescription();
}
