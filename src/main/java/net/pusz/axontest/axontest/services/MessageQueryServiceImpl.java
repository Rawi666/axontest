package net.pusz.axontest.axontest.services;

import java.util.List;
import java.util.stream.Collectors;

import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.stereotype.Service;

@Service
public class MessageQueryServiceImpl implements MessageQueryService {
    private final EventStore eventStore;

    public MessageQueryServiceImpl(EventStore eventStore) {
        this.eventStore = eventStore;
    }

    @Override
    public List<Object> listEventsForMessage(String id) {
        return this.eventStore.readEvents(id).asStream().map(s -> s.getPayload()).collect(Collectors.toList());
    }
}