package pack;

public class Burguer extends Food {

    protected Burguer() {
        initIngredients();
    }


    private void initIngredients() {
        ingredients.put("Burger", 2);
        ingredients.put("Cheese", 2);
        ingredients.put("Meat", 2);
        ingredients.put("Salad", 1);
    }


}


