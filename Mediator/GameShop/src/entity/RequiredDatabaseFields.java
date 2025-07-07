package entity;

import org.bson.BsonType;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonRepresentation;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

public abstract class RequiredDatabaseFields {
    @BsonId
    @BsonRepresentation(BsonType.OBJECT_ID)
    protected String id;
    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;

    public RequiredDatabaseFields() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // Event
    public void onUpdated() {
        this.createdAt = LocalDateTime.now();
    }

    // Getter
    public String getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    // Setter
    protected void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    protected void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    protected void setId(String id) {
        this.id = id;
    }
}
