package entity;

import java.math.BigDecimal;

public class Game extends RequiredDatabaseFields {
    private String name;
    private String description;
    private BigDecimal price;

    public Game() {
        super();
    }

    protected Game(String name, String description, BigDecimal price) {
        super();
        this.name = name;
        this.description = description;
        this.price = price;
    }

    // Getter
    public BigDecimal getPrice() {
        return price;
    }
    public String getDescription() {
        return description;
    }
    public String getName() {
        return name;
    }

    // Setter
    protected void setDescription(String description) {
        this.description = description;
    }
    protected void setPrice(BigDecimal price) {
        this.price = price;
    }
    protected void setName(String name) {
        this.name = name;
    }

    public GameBuilder toBuilder() {
        return new GameBuilder(this);
    }

    @Override
    public String toString() {
        return "Game{" +
                "id='" + id + '\'' +
                ", updatedAt=" + updatedAt +
                ", createdAt=" + createdAt +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
