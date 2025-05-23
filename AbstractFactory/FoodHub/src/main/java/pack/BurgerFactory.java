package pack;

public class BurgerFactory implements FoodFactory{
    @Override
    public Food getFood() {
        return new Burguer();
    }
}
