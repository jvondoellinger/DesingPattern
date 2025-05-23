package pack;

public class HotDog extends Food {

    protected HotDog() {
        initIngredients();
    }

    private void initIngredients() {
        ingredients.put("Bread", 1);
        ingredients.put("Sausage", 1);
        ingredients.put("Corn", 1);
        ingredients.put("Potato puree", 1);
    }
}
