package pack;

public class PizzaFactory {
    private PizzaFactory() {}

    public static Pizza getChocolatePizza() { return new ChocolatePizza(); }

    public static Pizza getMucarelaPizza() { return new MussarelaPizza(); }
    public static Pizza getPeperonePizza() { return new PeperonePizza(); }

}
