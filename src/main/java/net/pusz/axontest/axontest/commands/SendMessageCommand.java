package net.pusz.axontest.axontest.commands;

import lombok.Data;

@Data
public class SendMessageCommand extends BaseCommand<String> {
    private String message;

    public SendMessageCommand(final String id, final String message) {
        super(id);
        this.message = message;
    }
}