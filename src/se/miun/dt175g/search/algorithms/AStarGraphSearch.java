package se.miun.dt175g.search.algorithms;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Set;

import se.miun.dt175g.search.Heuristic;
import se.miun.dt175g.search.Node;
import se.miun.dt175g.search.Problem;
import se.miun.dt175g.search.SearchAlgorithm;

/**
 * A* Search implementation.
 * Similar to Uniform Cost Search, but uses f(n) = g(n) + h(n) for node ordering,
 * where g(n) is the path cost and h(n) is the heuristic estimate.
 */

public class AStarGraphSearch<S, A> implements SearchAlgorithm<S, A> {

    private Heuristic<S> heuristic;

    public AStarGraphSearch(Heuristic<S> heuristic) {
        super();
        this.heuristic = heuristic;
    }
    
    @Override
    public Optional<Node<S, A>> solve(Problem<S, A> searchProblem) {
        System.out.println("Solving (A* graph)...");
        
        // heuristic.apply(State) returns a Double value based on the given heuristic used.
        Comparator<Node<S, A>> nodeComparator = (a,b) -> 
            Double.compare(heuristic.apply(a.state) + a.pathCost, 
                         heuristic.apply(b.state) + b.pathCost);
        
        // TODO: The structure will be similar to Uniform Cost Search
        // The main difference is that we're already using f(n) = g(n) + h(n) in the comparator
        
        throw new UnsupportedOperationException("A* Graph Search not implemented yet.");
    }

}
