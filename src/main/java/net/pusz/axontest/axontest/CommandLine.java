package net.pusz.axontest.axontest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.var;
import net.pusz.axontest.axontest.services.MessageCommandService;

@Component
public class CommandLine implements CommandLineRunner {
    private static Logger Log = LoggerFactory.getLogger(CommandLine.class);
    private MessageCommandService messageCommandService;

    public CommandLine(MessageCommandService messageCommandService) {
        super();
        this.messageCommandService = messageCommandService;
    }

    @Override
    public void run(String... args) throws Exception {
        var isProducer = System.getenv("IS_PRODUCER");
        if (isProducer != null && isProducer.equalsIgnoreCase("yes")) {
            Log.info("-==Starting producer==-");
            var msg = "MessageZXC";

            for (int i = 0; i < 100; i++) {
                messageCommandService.sendMessage(msg + i);
                Thread.sleep(1000);
            }
        } else {
            Log.info("-==Starting consumer==-");
        }
    }

}