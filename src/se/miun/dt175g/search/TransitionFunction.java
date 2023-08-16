package se.miun.dt175g.search;

/**
 * Maps state-action pairs to states.
 * A model that captures the transitions between states.
 *
 * @author Christoffer Fink
 */
@FunctionalInterface
public interface TransitionFunction<S,A> {

  /** Transition to new state given current state and an action. */
  public S transition(S state, A action);
}
