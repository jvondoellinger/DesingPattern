package pack;

import java.util.List;

public class PeperonePizza extends Pizza {
    protected PeperonePizza() {
        ingredients = List.of(
                new Ingredient("Farinha"),
                new Ingredient("Agua"),
                new Ingredient("Fermento"),
                new Ingredient("Açucar"),
                new Ingredient("Sal"),
                new Ingredient("Azeite"),
                new Ingredient("Tomate"),
                new Ingredient("Azeite"),
                new Ingredient("Cebola"),
                new Ingredient("pimentão"),
                new Ingredient("Queijo mussarela"),
                new Ingredient("Salame italiano"),
                new Ingredient("Pimenta calabresa")
        );
    }
}
