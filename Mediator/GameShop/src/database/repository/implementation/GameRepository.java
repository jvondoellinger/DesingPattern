package database.repository.implementation;

import com.mongodb.client.result.InsertOneResult;
import com.mongodb.reactivestreams.client.MongoCollection;
import database.config.MongoConfiguration;
import database.repository.promisse.IGameRepository;
import entity.Game;
import org.bson.types.ObjectId;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import static com.mongodb.client.model.Filters.eq;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Predicate;

public class GameRepository implements IGameRepository {

    private final MongoConfiguration configuration;

    public GameRepository(MongoConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public Mono<Void> add(Game game) {
        return Mono.create(sink ->
            configuration.getGameCollection().insertOne(game).subscribe(
                    new Subscriber<InsertOneResult>() {
                        @Override
                        public void onSubscribe(Subscription s) {
                            s.request(1); // inicia
                        }

                        @Override
                        public void onNext(InsertOneResult result) {
                            // pode ignorar se quiser
                        }

                        @Override
                        public void onError(Throwable t) {

                        }

                        @Override
                        public void onComplete() {

                        }
                    })
        );
    }

    @Override
    public Mono<Void> update(Game game) {
        return null;
    }

    @Override
    public Mono<Void> delete(Game game) {
        return null;
    }

    @Override
    public Flux<Game> get() {
        var collection = configuration.getGameCollection();
        return Flux.from(collection.find());
    }

    @Override
    public Mono<Game> get(String identifier) {
        var collection = configuration.getGameCollection();
        var id = new ObjectId(identifier);
        return Mono.from(collection.find(eq("_id", id)).first());
    }
}
