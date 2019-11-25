package net.pusz.axontest.axontest.aggregates;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.pusz.axontest.axontest.commands.SendMessageCommand;
import net.pusz.axontest.axontest.events.MessageReceivedEvent;

@Aggregate
public class MessageAggregate {
    private static Logger Log = LoggerFactory.getLogger(MessageAggregate.class);

    @AggregateIdentifier
    private String id;

    private String message;

    public MessageAggregate() {
    }

    @CommandHandler
    public MessageAggregate(SendMessageCommand sendMessageCommand) {
        AggregateLifecycle.apply(new MessageReceivedEvent(sendMessageCommand.id, sendMessageCommand.getMessage()));
    }

    @EventSourcingHandler
    protected void on(MessageReceivedEvent messageReceivedEvent) {
        this.id = messageReceivedEvent.getId();
        this.message = messageReceivedEvent.getMessage();

        Log.info("!!!!!!!!!!!!!!!!" + this.message);
    }
}