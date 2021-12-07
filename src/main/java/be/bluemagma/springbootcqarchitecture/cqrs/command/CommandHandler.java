package be.bluemagma.springbootcqarchitecture.cqrs.command;

import be.bluemagma.springbootcqarchitecture.cqrs.BaseHandler;
import be.bluemagma.springbootcqarchitecture.cqrs.Dispatchable;

public interface CommandHandler<TCommand extends Dispatchable<TResult>, TResult> extends BaseHandler<TCommand, TResult> {
}
