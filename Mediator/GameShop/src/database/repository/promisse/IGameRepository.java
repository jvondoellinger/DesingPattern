package database.repository.promisse;

import entity.Game;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Predicate;

public interface IGameRepository {
    Mono<Void> add(Game game);
    Mono<Void> update(Game game);
    Mono<Void> delete(Game game);
    Flux<Game> get();
    Mono<Game> get(String identifier);

    // Flux<Game>> get(Predicate<Game> predicate); // To another version...
}
