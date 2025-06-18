package menu;

import java.util.concurrent.CompletableFuture;

public interface IMenu {
    CompletableFuture<Void> show();
}
