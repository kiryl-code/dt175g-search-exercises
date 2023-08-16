package se.miun.dt175g.search;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Maps nodes to successor nodes.
 *
 * @author Christoffer Fink
 */
@FunctionalInterface
public interface SuccessorFunction<S,A> {

  /** Returns the collection of successors for the given node/state. */
  public Collection<Node<S, A>> successorsOf(Node<S,A> node);

  // This is a convenience function.
  /**
   * Generates a SuccessorFunction from Cost, Transition, and Actions
   * functions.
   */
  public static <S,A> SuccessorFunction <S,A> from(CostFunction<A> c,
      TransitionFunction<S,A> model, ActionsFunction<S,A> actions) {
    return node -> {
      final Collection<Node<S,A>> successors = new ArrayList<>();
      for (A action : actions.possibleActionsIn(node.state)) {
        final S result = model.transition(node.state, action);
        final double cost = c.costOf(action);
        successors.add(node.successor(result, action, cost));
      }
      return successors;
    };
  }
}
