package be.bluemagma.springbootcqarchitecture.cqrs;

/**
 * Used for requests that change the application state
 */
public interface Command<TResult> extends Dispatchable<TResult> {
}
