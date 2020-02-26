package net.pusz.axontest.axontest.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateMessageAggregate {
    @TargetAggregateIdentifier
    private String id;
}