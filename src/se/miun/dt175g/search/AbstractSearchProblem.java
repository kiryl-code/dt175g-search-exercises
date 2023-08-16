package se.miun.dt175g.search;

import java.util.ArrayList;
import java.util.Collection;

/**
 * A template for defining problems.
 * This is a convenience class with the main purpose of making the problem
 * definition more object-oriented.
 * <p>
 * The default implementation of {@code isGoal(S)} requires a (non-null) goal
 * state to be supplied to the constructor, which candidate states will then be
 * compared to for equality. A more elaborate goal test (that examines a state
 * for various criteria) will require
 *
 * @author Christoffer Fink
 */
public abstract class AbstractSearchProblem<S,A>
    implements Problem<S,A>, CostFunction<A>, TransitionFunction<S,A>,
               ActionsFunction<S,A>, GoalTest<S> {

  private final S initialState;
  private final S goalState;

  /**
   * Using this constructor effectively disables the default implementation of
   * {@code isGoal(S)}.
   */
  public AbstractSearchProblem(S initialState) {
    this(initialState, null);
  }

  public AbstractSearchProblem(S initialState, S goalState) {
    this.initialState = initialState;
	this.goalState = goalState;
  }

  @Override
  public Node<S,A> getInitialNode() {
    return Node.root(initialState);
  }

  /**
   * Uses the {@code possibleActionsIn(S)}, {@code transition(S, A)}, and
   * {@code costOf(A)} methods.
   */
  @Override
  public Collection<Node<S,A>> successorsOf(Node<S,A> node) {
    Collection<Node<S, A>> successors = new ArrayList<>();
    for (A action : possibleActionsIn(node.state)) {
      S result = transition(node.state, action);
      double cost = costOf(action);
      successors.add(node.successor(result, action, cost));
    }
    return successors;
  }

  /** Uses a uniform cost of 1.0 by default. */
  @Override
  public double costOf(A action) {
    return 1.0;
  }

  @Override
  public boolean isGoal(Node<S,A> node) {
    return isGoal(node.state);
  }

  /**
   * Compares states against a goal state set in the constructor.
   * Concrete problems that need a goal test that is more elaborate than a
   * simple comparison must override this method.
   * @throws UnsupportedOperationException if no goal state was set in the
   * constructor (or it was set to null).
   */
  public boolean isGoal(S state) {
	  if (goalState == null) {
		  String msg = "Default implementation requires a (non-null) goal state!";
		  throw new UnsupportedOperationException(msg);
	  }
	  return goalState.equals(state);
  }

}
