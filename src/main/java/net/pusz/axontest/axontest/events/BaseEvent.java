package net.pusz.axontest.axontest.events;

import lombok.Data;

@Data
public class BaseEvent<T> {
    private T id;

    public BaseEvent(T id) {
        this.id = id;
    }
}