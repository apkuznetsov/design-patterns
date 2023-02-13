package kuznetsov.abstract_factory.concrete_stores;

import kuznetsov.abstract_factory.abstract_pizzas.Pizza;
import kuznetsov.abstract_factory.abstract_pizzas.PizzaIngredientFactory;
import kuznetsov.abstract_factory.abstract_pizzas.PizzaStore;
import kuznetsov.abstract_factory.concrete_ingredient_factories.NewYorkPizzaIngredientFactory;
import kuznetsov.abstract_factory.concrete_pizzas.CheesePizza;
import kuznetsov.abstract_factory.concrete_pizzas.ClamPizza;
import kuznetsov.abstract_factory.concrete_pizzas.PepperoniPizza;
import kuznetsov.abstract_factory.concrete_pizzas.VeggiePizza;

public class NewYorkPizzaStore extends PizzaStore {

    protected Pizza createPizza(String item) {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory =
                new NewYorkPizzaIngredientFactory();

        if (item.equals("cheese")) {

            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("New York Style Cheese Pizza");

        } else if (item.equals("veggie")) {

            pizza = new VeggiePizza(ingredientFactory);
            pizza.setName("New York Style Veggie Pizza");

        } else if (item.equals("clam")) {

            pizza = new ClamPizza(ingredientFactory);
            pizza.setName("New York Style Clam Pizza");

        } else if (item.equals("pepperoni")) {

            pizza = new PepperoniPizza(ingredientFactory);
            pizza.setName("New York Style Pepperoni Pizza");

        }

        return pizza;
    }
}
