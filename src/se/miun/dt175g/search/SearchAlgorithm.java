package se.miun.dt175g.search;

import java.util.Optional;

/**
 * A search algorithm. Solves some problem by searching.
 *
 * @author Christoffer Fink
 */
@FunctionalInterface
public interface SearchAlgorithm<S,A> {
  public Optional<Node<S,A>> solve(Problem<S,A> searchProblem);
}
