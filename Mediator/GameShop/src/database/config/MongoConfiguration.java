package database.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.reactivestreams.client.MongoClients;
import entity.Game;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import com.mongodb.reactivestreams.client.MongoCollection;

public class MongoConfiguration {
    private static final String DATABASE_NAME = "study_design-pattern";
    private static final String COLLECTION_NAME = "game-shop";
    private static final String CONNECTION_STRING = "mongodb://localhost:27017";


    public MongoConfiguration() {

    }

    private CodecRegistry makeCodecRegistry() {
        return CodecRegistries.fromRegistries(
                    MongoClientSettings.getDefaultCodecRegistry(),
                    CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build())
        );
    }

    private MongoClientSettings makeSettings() {
        return MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(CONNECTION_STRING))
                .codecRegistry(makeCodecRegistry())
                .build();
    }


    public MongoCollection<Game> getGameCollection() {
        return MongoClients.create(makeSettings())
                .getDatabase(DATABASE_NAME)
                .getCollection(COLLECTION_NAME, Game.class);
    }
}
