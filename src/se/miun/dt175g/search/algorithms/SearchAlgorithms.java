package se.miun.dt175g.search.algorithms;

import se.miun.dt175g.search.Heuristic;
import se.miun.dt175g.search.InformedSearchAlgorithm;
import se.miun.dt175g.search.SearchAlgorithm;

/**
 * @author Christoffer Fink
 */
public interface SearchAlgorithms<S,A> {

  /** Breadth-First Search (tree version). **/
  default public SearchAlgorithm<S,A> bfsTree() {
    throw new UnsupportedOperationException("Not implemented.");
  }

  /** Depth-First Search (tree version). **/
  default public SearchAlgorithm<S,A> dfsTree() {
    throw new UnsupportedOperationException("Not implemented.");
  }

  /** Iterative deepening DFS (tree version). **/
  default public SearchAlgorithm<S,A> iterativeDfsTree(int maxDepth) {
    throw new UnsupportedOperationException("Not implemented.");
  }

  /** Uniform-Cost Search (tree version). **/
  default public SearchAlgorithm<S,A> ucsTree() {
    throw new UnsupportedOperationException("Not implemented.");
  }

  /** Greedy best-first search (tree version). **/
  default public SearchAlgorithm<S,A> greedyTree(Heuristic<S> h) {
    throw new UnsupportedOperationException("Not implemented.");
  }

  /** A-star search, with fixed heuristic (tree version). **/
  default public SearchAlgorithm<S,A> astarTree(Heuristic<S> h) {
    throw new UnsupportedOperationException("Not implemented.");
  }

  /** A-star search (tree version). **/
  default public InformedSearchAlgorithm<S,A> astarTree() {
    throw new UnsupportedOperationException("Not implemented.");
  }


  /** Breadth-First Search (graph version). **/
  default public SearchAlgorithm<S,A> bfsGraph() {
    throw new UnsupportedOperationException("Not implemented.");
  }

  /** Depth-First Search (graph version). **/
  default public SearchAlgorithm<S,A> dfsGraph() {
    throw new UnsupportedOperationException("Not implemented.");
  }

  /** Iterative deepening DFS (graph version). **/
  default public SearchAlgorithm<S,A> iterativeDfsGraph(int maxDepth) {
    throw new UnsupportedOperationException("Not implemented.");
  }

  /** Uniform-Cost Search (graph version). **/
  default public SearchAlgorithm<S,A> ucsGraph() {
    throw new UnsupportedOperationException("Not implemented.");
  }

  /** Greedy best-first search (graph version). **/
  default public SearchAlgorithm<S,A> greedyGraph(Heuristic<S> h) {
    throw new UnsupportedOperationException("Not implemented.");
  }

  /** A-star search, with fixed heuristic (graph version). **/
  default public SearchAlgorithm<S,A> astarGraph(Heuristic<S> h) {
	  throw new UnsupportedOperationException("Not implemented.");
  }

  /** A-star search (graph version). **/
  default public InformedSearchAlgorithm<S,A> astarGraph() {
    throw new UnsupportedOperationException("Not implemented.");
  }

}
