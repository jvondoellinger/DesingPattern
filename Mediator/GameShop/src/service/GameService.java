package service;

import database.repository.promisse.IGameRepository;
import entity.Game;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class GameService {
    private final IGameRepository repository;

    public GameService(IGameRepository repository) {
        this.repository = repository;
    }

    public Mono<Void> add(Game game) {
        if (game == null) {
            throw new NullPointerException("Game cannot be null!");
        }
        return repository.add(game);
    }
    public Mono<Void> delete(Game game) {
        if(game == null) {
            throw new NullPointerException("Game cannot be null!");
        }
        return repository.delete(game);
    }
    public Mono<Void> update(Game game) {
        if(game == null) {
            throw new NullPointerException("Game cannot be null!");
        }
        return repository.update(game);
    }
    public Flux<Game> get() {
        return repository.get();
    }
    public Mono<Game> get(String identifier) {
        return repository.get(identifier);
    }
}
