package se.miun.dt175g.search;

/**
 * Checks whether a state satisfies the goal test.
 *
 * @author Christoffer Fink
 */
@FunctionalInterface
public interface GoalTest<S> {

  /** Does the given state satisfy the goal test? */
  public boolean isGoal(S state);

}
