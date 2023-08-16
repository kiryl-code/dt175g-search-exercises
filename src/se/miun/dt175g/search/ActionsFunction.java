package se.miun.dt175g.search;

import java.util.Collection;

/**
 * Maps states to collections of possible actions.
 *
 * @author Christoffer Fink
 */
@FunctionalInterface
public interface ActionsFunction<S,A> {

  /** Returns the actions that are possible in the given state. */
  public Collection<A> possibleActionsIn(S state);
}
