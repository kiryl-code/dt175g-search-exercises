package se.miun.dt175g.search.util;

import java.util.List;

import se.miun.dt175g.search.Node;
import se.miun.dt175g.search.Problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collection;



/**
 * @author Christoffer Fink
 */
public class InstrumentedProblem<S,A> implements Problem<S,A> {

  private final Problem<S,A> wrapped;
  private final List<Node<S,A>> expansions = new LinkedList<>();
  private final List<Node<S,A>> goalTests = new LinkedList<>();
  private long startTime = -1;
  private long runTime = -1;

  private InstrumentedProblem(Problem<S,A> problem) {
    this.wrapped = problem;
  }

  public static <S,A> InstrumentedProblem<S,A> instrument(Problem<S,A> problem) {
    return new InstrumentedProblem<>(problem);
  }

  @Override
  public Node<S,A> getInitialNode() {
    // Start timer on the **first** call.
    if (startTime == -1) {
      startTime = System.currentTimeMillis();
    }
    return wrapped.getInitialNode();
  }

  @Override
  public Collection<Node<S,A>> successorsOf(Node<S,A> node) {
    expansions.add(node);
    return wrapped.successorsOf(node);
  }

  @Override
  public boolean isGoal(Node<S,A> node) {
    goalTests.add(node);
    boolean result = wrapped.isGoal(node);
    if (result) {
      runTime = System.currentTimeMillis() - startTime;
    }
    return result;
  }

  public int getExpansions() {
    return expansions.size();
  }

  public List<Node<S,A>> getExpansionOrder() {
    return new ArrayList<>(expansions);
  }

  public int getGoalTests() {
    return goalTests.size();
  }

  public List<Node<S,A>> getGoalTestOrder() {
    return new ArrayList<>(goalTests);
  }

  /**
   * Returns the number of milliseconds (as reported by
   * {@code System.currentTimeMillis()}) starting at the first call to
   * {@link #getInitialNode()} and up to the <strong>last</strong> call to
   * {@link #isGoal(Object)}.
   */
  public long getMilliSeconds() {
    return runTime;
  }

}
