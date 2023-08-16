package se.miun.dt175g.search;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Represents a search problem in a way that is suitable for graph/tree search
 * algorithms.
 *
 * Implementations need to define the starting node, the goal test, and
 * the {@link #successorsOf(Node)} method.
 *
 * @author Christoffer Fink
 */
public interface Problem<S,A> {

  public Node<S,A> getInitialNode();

  /** Check whether the given state satisfies the goal test. */
  public boolean isGoal(Node<S,A> node);

  /** Expands a node and returns all successor nodes. */
  public Collection<Node<S,A>> successorsOf(Node<S,A> node);

  public static <S,A> Builder<S,A> builder() {
    return new Builder<>();
  }

  /**
   * Builds search Problem instances flexibly.
   */
  public static class Builder<S,A> {

    private Supplier<S> initialState;
    private GoalTest<S> goalTest;
    private SuccessorFunction<S,A> successorFunction;

    private Builder() {
      successorMapping(Collections.emptyMap()); // Could be valid.
    }

    public static <S,A> Builder<S,A> builder() {
      return new Builder<S,A>();
    }

    public Builder<S,A> initialState(S state) {
      if (state == null) {
        throw new IllegalArgumentException("Refusing to create Search Problem with null initial state");
      }
      initialState = () -> state;
      return this;
    }

    /**
     * Overrides any goals set by {@link #goalStates(Collection)} or
     * {@link #goalTest(GoalTest)}
     */
    public Builder<S,A> goalState(S state) {
      return goalTest(state::equals);
    }

    /**
     * Overrides any goals set by {@link #goalState(Object)} or
     * {@link #goalTest(GoalTest)}
     */
    public Builder<S,A> goalStates(Collection<S> states) {
      return goalTest(states::contains);
    }

    /**
     * Overrides any goals set by {@link #goalStates(Collection)} or
     * {@link #goalState(Object)}
     */
    public Builder<S,A> goalTest(GoalTest<S> goalTest) {
      if (goalTest == null) {
        throw new IllegalArgumentException("Refusing to create Search Problem with null goal state");
      }
      this.goalTest = goalTest;
      return this;
    }

    public Builder<S,A> successorMapping(Map<S, Collection<Node<S,A>>> sf) {
      return successorFunction(sf::get);
    }

    /**
     * Consider having one automatically synthesized for you by
     * {@link SuccessorFunction#from(CostFunction, TransitionFunction, ActionsFunction)}.
     */
    public Builder<S,A> successorFunction(SuccessorFunction<S,A> successorFunction) {
      if (successorFunction == null) {
        throw new IllegalArgumentException("Refusing to create Search Problem with null successor function");
      }
      this.successorFunction = successorFunction;
      return this;
    }

    public Problem<S,A> build() {
      if (initialState == null || goalTest == null) {
        throw new IllegalStateException("Refusing to create Search Problem with null initial and/or goal state");
      }
      return new ProblemImpl<S,A>(initialState, goalTest, successorFunction);
    }

    private static class ProblemImpl<S,A> implements Problem<S,A> {

      private final Supplier<S> start;
      private final GoalTest<S> goalTest;
      private final SuccessorFunction<S,A> successorFunction;

      private ProblemImpl(Supplier<S> startState, GoalTest<S> goalTest,
          SuccessorFunction<S,A> successorFunction) {
        this.start = startState;
        this.goalTest = goalTest;
        this.successorFunction = successorFunction;
      }

      @Override
      public Node<S,A> getInitialNode() {
        return Node.root(start.get());
      }

      /** Get the successors for the given state. */
      @Override
      public Collection<Node<S,A>> successorsOf(Node<S,A> state) {
        return successorFunction.successorsOf(state);
      }

      @Override
      public boolean isGoal(Node<S,A> node) {
        return goalTest.isGoal(node.state);
      }
    }
  }
}
