package se.miun.dt175g.search;

import java.util.Optional;


/**
 * A search algorithm that can use a heuristic to guide its search.
 * An informed search algorithm with a 0 heuristic is just a regular
 * (uninformed) search algorithm.
 *
 * @author Christoffer Fink
 */
@FunctionalInterface
public interface InformedSearchAlgorithm<S,A> extends SearchAlgorithm<S,A> {

  public Optional<Node<S,A>> solve(Problem<S,A> problem, Heuristic<S> heuristic);

  @Override
  default public Optional<Node<S,A>> solve(Problem<S,A> problem) {
    return solve(problem, s -> 0);
  }

  public static <S,A> SearchAlgorithm<S,A> curry(InformedSearchAlgorithm<S,A> is, Heuristic<S> h) {
    return p -> is.solve(p, h);
  }

}
