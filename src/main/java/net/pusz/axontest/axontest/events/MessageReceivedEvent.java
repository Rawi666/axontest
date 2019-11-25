package net.pusz.axontest.axontest.events;

import lombok.Data;

@Data
public class MessageReceivedEvent extends BaseEvent<String> {
    private String message;

    public MessageReceivedEvent(final String id, final String message) {
        super(id);
        this.message = message;
    }
}