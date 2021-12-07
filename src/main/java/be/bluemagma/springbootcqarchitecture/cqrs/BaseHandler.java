package be.bluemagma.springbootcqarchitecture.cqrs;

/**
 * Base handler for all types of {@link Dispatchable}
 * @param <TResult> the return type of the dispatchable
 */
public interface BaseHandler<TDispatchable extends Dispatchable<TResult>, TResult> {

  TResult handle(final TDispatchable dispatchable);
}
