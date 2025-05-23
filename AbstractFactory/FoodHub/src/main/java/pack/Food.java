package pack;

import java.util.HashMap;
import java.util.Map;

public abstract class Food {
    protected Map<String, Integer> ingredients;
    protected Food() {
        ingredients = new HashMap<>();
    }

    public Map<String, Integer> getIngredients() {
        return ingredients;
    }

    public void removeIngredient(String ingredient) {
        ingredients.remove(ingredient);
    }

    public void addIngredient(String ingredient) {
        Integer value = ingredients.get(ingredient);
        if(value != null) {
            ingredients.put(ingredient, value + 1);
        } else {
            ingredients.put(ingredient, 1);
        }
    }

    @Override
    public String toString() {
        var text = ingredients.toString();
        return text;
    }
}
