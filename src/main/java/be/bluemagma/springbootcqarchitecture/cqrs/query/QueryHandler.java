package be.bluemagma.springbootcqarchitecture.cqrs.query;

import be.bluemagma.springbootcqarchitecture.cqrs.BaseHandler;
import be.bluemagma.springbootcqarchitecture.cqrs.Dispatchable;

public interface QueryHandler<TQuery extends Dispatchable<TResult>, TResult> extends BaseHandler<TQuery, TResult> {
}
