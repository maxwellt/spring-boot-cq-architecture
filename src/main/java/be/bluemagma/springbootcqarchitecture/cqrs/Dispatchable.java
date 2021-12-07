package be.bluemagma.springbootcqarchitecture.cqrs;

import be.bluemagma.springbootcqarchitecture.cqrs.command.Command;
import be.bluemagma.springbootcqarchitecture.cqrs.query.Query;

/**
 * Marker interface for {@link Query} or {@link Command}
 */
public interface Dispatchable<TResult> {
}
