package net.pusz.axontest.axontest.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AggregateCreatedEvent {
    private String id;
}
