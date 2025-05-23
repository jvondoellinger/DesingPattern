package pack;

public class HotDogFactory implements FoodFactory {
    @Override
    public Food getFood() {
        return new HotDog();
    }
}
