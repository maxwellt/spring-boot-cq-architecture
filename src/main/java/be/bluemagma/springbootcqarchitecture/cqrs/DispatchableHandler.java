package be.bluemagma.springbootcqarchitecture.cqrs;

public interface DispatchableHandler {

  <TResult> TResult dispatch(Dispatchable<TResult> dispatchable);
}
