package net.pusz.axontest.axontest.aggregates;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import lombok.extern.slf4j.Slf4j;
import net.pusz.axontest.axontest.commands.CreateMessageAggregate;
import net.pusz.axontest.axontest.commands.SendMessageCommand;
import net.pusz.axontest.axontest.events.AggregateCreatedEvent;
import net.pusz.axontest.axontest.events.MessageReceivedEvent;

@Aggregate
@Slf4j
public class MessageAggregate {
    @AggregateIdentifier
    private String id;

    public MessageAggregate() {
    }

    @CommandHandler
    public MessageAggregate(CreateMessageAggregate cmd) {
        AggregateLifecycle.apply(new AggregateCreatedEvent(cmd.getId()));
        log.info("Aggregate EventSourcingHandler: Aggregate {} created", this.id);
    }

    @EventSourcingHandler
    public void on(AggregateCreatedEvent messageReceivedEvent) {
        this.id = messageReceivedEvent.getId();
    }

    @CommandHandler
    public void when(SendMessageCommand sendMessageCommand) {
        AggregateLifecycle.apply(new MessageReceivedEvent(sendMessageCommand.getId(), sendMessageCommand.getMessage()));
    }

    @EventSourcingHandler
    public void on(MessageReceivedEvent messageReceivedEvent) {
        final var message = messageReceivedEvent.getMessage();
        log.info("Aggregate EventSourcingHandler: id={} message={}", this.id, message);
    }
}