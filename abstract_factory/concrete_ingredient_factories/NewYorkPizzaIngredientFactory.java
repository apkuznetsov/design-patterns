package kuznetsov.abstract_factory.concrete_ingredient_factories;

import kuznetsov.abstract_factory.abstract_ingredients.*;
import kuznetsov.abstract_factory.abstract_pizzas.PizzaIngredientFactory;
import kuznetsov.abstract_factory.concrete_ingredients.*;

public class NewYorkPizzaIngredientFactory implements PizzaIngredientFactory {

    public Dough createDough() {
        return new ThinCrustDough();
    }

    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    public Veggies[] createVeggies() {
        Veggies[] veggies = {new Garlic(), new Onion(), new Mushroom(), new RedPepper()};
        return veggies;
    }

    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    public Clams createClam() {
        return new FreshClams();
    }
}
