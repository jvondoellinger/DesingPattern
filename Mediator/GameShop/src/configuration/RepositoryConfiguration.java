package configuration;

import anootation.BadCode;
import database.config.MongoConfiguration;
import database.repository.implementation.GameRepository;
import database.repository.promisse.IGameRepository;
import entity.GameBuilder;
import java.math.BigDecimal;
import java.util.Objects;

@BadCode
public class RepositoryConfiguration {
    private static IGameRepository repository;

    public static IGameRepository getInstance() {
        if(Objects.isNull(repository)) {
            var configuration = new MongoConfiguration();
            repository = new GameRepository(configuration);
        }
        // To tests - developing
/*        System.out.println("Test");
        var game = GameBuilder.builder().name("test").description("des").price(new BigDecimal(123)).build();
        repository.add(game).block();*/
        return repository;
    }
}
