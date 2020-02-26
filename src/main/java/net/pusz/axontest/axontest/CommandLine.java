package net.pusz.axontest.axontest;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import net.pusz.axontest.axontest.commands.CreateMessageAggregate;
import net.pusz.axontest.axontest.commands.SendMessageCommand;

@Component
@Slf4j
public class CommandLine implements CommandLineRunner {
    private CommandGateway commandGateway;

    @Autowired
    public CommandLine(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @Override
    public void run(String... args) throws Exception {
        var isProducer = System.getenv("IS_PRODUCER");
        if (isProducer != null && isProducer.equalsIgnoreCase("yes")) {
            log.info("-==Starting producer==-");
            var msg = "MessageABC";

            commandGateway.send(new CreateMessageAggregate("CONST_ID"));

            for (int i = 0; i < 100; i++) {
                commandGateway.send(new SendMessageCommand("CONST_ID", msg + i));
                Thread.sleep(1000);
            }
        } else {
            log.info("-==Starting consumer==-");
        }
    }

}