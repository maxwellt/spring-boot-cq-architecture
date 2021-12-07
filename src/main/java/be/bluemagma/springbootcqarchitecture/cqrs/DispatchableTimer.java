package be.bluemagma.springbootcqarchitecture.cqrs;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DispatchableTimer implements DispatchableHandler {

  private final DispatchableHandler next;

  public DispatchableTimer(DispatchableHandler next) {
    this.next = next;
  }

  @Override
  public <TResult> TResult dispatch(Dispatchable<TResult> dispatchable) {
    long start = System.currentTimeMillis();
    TResult result = this.next.dispatch(dispatchable);
    long stop = System.currentTimeMillis();

    long durationInMs = stop - start;
    log.info("Executing {} took {}ms", dispatchable.getClass().getSimpleName(), durationInMs);

    return result;
  }
}
