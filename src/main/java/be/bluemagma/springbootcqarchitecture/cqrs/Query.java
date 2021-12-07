package be.bluemagma.springbootcqarchitecture.cqrs;

/**
 * Used for requests that read the application state
 */
public interface Query<TResult> extends Dispatchable<TResult> {
}
