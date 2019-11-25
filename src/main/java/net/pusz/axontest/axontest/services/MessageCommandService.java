package net.pusz.axontest.axontest.services;

import java.util.concurrent.CompletableFuture;

public interface MessageCommandService {
    public CompletableFuture<String> sendMessage(String message);
}