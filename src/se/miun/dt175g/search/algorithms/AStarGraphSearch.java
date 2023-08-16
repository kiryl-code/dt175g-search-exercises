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
 * THIS CLASS IS INCOMPLETE. Anything that needs to be added can be done inside the while loop
 *
 * @author Peter Bergh
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
        Comparator<Node<S, A>> nodeComparator = (a,b) -> Double.compare(heuristic.apply(a.state) + a.pathCost, heuristic.apply(b.state) + b.pathCost);
        
        PriorityQueue<Node<S, A>> frontier = new PriorityQueue<>(10, nodeComparator);
        // A set with already explored States
        Set<S> explored = new HashSet<>();
        
        frontier.add(searchProblem.getInitialNode());

        boolean done = false;
        while (!done) {
           // TODO
        }

        return Optional.empty();
    }

}
