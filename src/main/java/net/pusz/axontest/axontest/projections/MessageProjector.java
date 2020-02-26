package net.pusz.axontest.axontest.projections;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import net.pusz.axontest.axontest.events.MessageReceivedEvent;

/**
 * MessageProjector
 */
@Service
@Slf4j
@ProcessingGroup("MessageProjector")
public class MessageProjector {
    @EventHandler
    @SneakyThrows
    public void on(final MessageReceivedEvent event) {
        log.info("Projection received START: id={} msg={}", event.getId(), event.getMessage());
        Thread.sleep(3000);
        log.info("Projection received END: id={} msg={}", event.getId(), event.getMessage());
    }
}