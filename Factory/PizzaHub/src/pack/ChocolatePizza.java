package pack;

import java.util.List;

public class ChocolatePizza extends Pizza {
    protected ChocolatePizza() {
        ingredients = List.of(
                new Ingredient("Farinha"),
                new Ingredient("Açucar"),
                new Ingredient("Sal"),
                new Ingredient("Ovos"),
                new Ingredient("Fermento"),
                new Ingredient("Leite"),
                new Ingredient("Oleo")
        );
    }
}
