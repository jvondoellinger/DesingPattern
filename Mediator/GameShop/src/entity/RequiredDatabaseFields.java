package entity;

import java.time.OffsetDateTime;
import java.util.UUID;

public abstract class RequiredDatabaseFields {
    protected String id;
    protected OffsetDateTime createdAt;
    protected OffsetDateTime updatedAt;

    protected RequiredDatabaseFields() {
        this.id = UUID.randomUUID().toString();
        this.createdAt = OffsetDateTime.now();
        this.updatedAt = OffsetDateTime.now();
    }

    public void onUpdated() {
        this.createdAt = OffsetDateTime.now();
    }
}
