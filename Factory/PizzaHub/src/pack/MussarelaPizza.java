package pack;

import java.util.List;

public class MussarelaPizza extends Pizza {
    protected MussarelaPizza() {
        ingredients = List.of(
            new Ingredient("Muçarela"),
            new Ingredient("Molho de Tomate"),
            new Ingredient("Trigo"),
            new Ingredient("Fubá"),
            new Ingredient("Fermento"),
            new Ingredient("Açucar"),
            new Ingredient("Sal"),
            new Ingredient("Oleo"),
            new Ingredient("Agua"),
            new Ingredient("Mussarela")
        );
    }
}
