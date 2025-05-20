package pack;

import java.util.List;


public abstract class Pizza {

    protected Pizza()  {
    }

    public List<Ingredient> getIngredients() { return ingredients; }

    protected List<Ingredient> ingredients;

    @Override
    public String toString() {
        var string = "ingredients: {";
        for (var ingredient : ingredients) {
            string += String.format(" %s", ingredient.getName());

            if(!ingredients.getLast().equals(ingredient)) {
                string += ", ";
            } // if not equals a last ingredient, don't add the ", "
        }
        string += "}";
        return string;
    }
}
