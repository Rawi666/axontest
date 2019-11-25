package net.pusz.axontest.axontest.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class BaseCommand<T> {

    @TargetAggregateIdentifier
    public T id;

    public BaseCommand(T id) {
        this.id = id;
    }
}