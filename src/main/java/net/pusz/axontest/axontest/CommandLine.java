package net.pusz.axontest.axontest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.var;
import net.pusz.axontest.axontest.services.MessageCommandService;

@Component
public class CommandLine implements CommandLineRunner {

    private MessageCommandService messageCommandService;

    public CommandLine(MessageCommandService messageCommandService) {
        super();
        this.messageCommandService = messageCommandService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (args.length > 0) {
            var msg = String.join(" ", args);

            for (int i = 0; i < 100; i++) {
                messageCommandService.sendMessage(msg + i);
                Thread.sleep(1000);
            }
        }
    }

}