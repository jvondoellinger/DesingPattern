package entity;

import java.math.BigDecimal;

public class GameBuilder {
    private final Game game;
    private GameBuilder() {
        this.game = new Game();
    }

    protected GameBuilder(Game game) {
        this.game = game;
    }

    // Get the class builder
    public static GameBuilder builder() {
        return new GameBuilder();
    }

    // Set fields
    public GameBuilder name(String name) {
        game.setName(name);
        return this;
    }
    public GameBuilder description(String description) {
        game.setDescription(description);
        return this;
    }
    public GameBuilder price(BigDecimal price) {
        game.setPrice(price);
        return this;
    }

    // Build class
    public Game build() {
        return game;
    }
}
