package be.bluemagma.springbootcqarchitecture.cqrs.query;

import be.bluemagma.springbootcqarchitecture.cqrs.Dispatchable;

/**
 * Used for requests that read the application state
 */
public interface Query<TResult> extends Dispatchable<TResult> {
}
