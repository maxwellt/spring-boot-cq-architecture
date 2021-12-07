package be.bluemagma.springbootcqarchitecture.cqrs.command;

import be.bluemagma.springbootcqarchitecture.cqrs.Dispatchable;

/**
 * Used for requests that change the application state
 */
public interface Command<TResult> extends Dispatchable<TResult> {
}
