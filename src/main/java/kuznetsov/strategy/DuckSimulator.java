package kuznetsov.strategy;

import kuznetsov.strategy.duck.Duck;
import kuznetsov.strategy.duck.MallardDuck;
import kuznetsov.strategy.duck.ModelDuck;
import kuznetsov.strategy.fly.FlyRocketPowered;

public class DuckSimulator {

    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.performQuack();
        mallard.performFly();

        Duck model = new ModelDuck();
        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
    }
}
