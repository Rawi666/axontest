package net.pusz.axontest.axontest.services;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import lombok.var;
import net.pusz.axontest.axontest.commands.SendMessageCommand;

@Service
public class MessageCommandServiceImpl implements MessageCommandService {
    private final CommandGateway commandGateway;

    public MessageCommandServiceImpl(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @Override
    public CompletableFuture<String> sendMessage(String message) {
        var cmd = new SendMessageCommand(UUID.randomUUID().toString(), message);
        return commandGateway.send(cmd);
    }
}