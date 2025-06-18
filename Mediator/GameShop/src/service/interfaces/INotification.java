package service.interfaces;

import entity.Game;

import java.util.concurrent.CompletableFuture;

public interface INotification {
    CompletableFuture<Void> send(String content, String replyTo);
}
