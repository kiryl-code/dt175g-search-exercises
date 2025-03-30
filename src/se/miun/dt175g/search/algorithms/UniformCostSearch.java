package se.miun.dt175g.search.algorithms;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Set;

import se.miun.dt175g.search.Node;
import se.miun.dt175g.search.Problem;
import se.miun.dt175g.search.SearchAlgorithm;

/**
 * Uniform Cost Search implementation.
 * This algorithm expands the node with the lowest path cost g(n).
 * 
 * TODO: Complete this implementation by:
 * 1. Creating appropriate comparator for the frontier
 * 2. Implementing the search loop
 * 3. Handling explored states to avoid cycles
 */
public class UniformCostSearch<S, A> implements SearchAlgorithm<S, A> {

    @Override
    public Optional<Node<S, A>> solve(Problem<S, A> searchProblem) {
        System.out.println("Solving (uniform cost)...");
        
        // TODO: Create a comparator that orders nodes by their path cost
        Comparator<Node<S, A>> nodeComparator = null;  // Hint: Use path cost for comparison
        
        // TODO: Initialize the frontier (priority queue) and explored set
        
        // TODO: Add initial node to frontier
        
        // TODO: Implement the main search loop
        // Hint 1: Check if frontier is empty
        // Hint 2: Get next node with lowest path cost
        // Hint 3: Check if it's a goal
        // Hint 4: Add to explored set
        // Hint 5: Generate and handle successors
        
        throw new UnsupportedOperationException("Uniform Cost Search not implemented yet.");
    }
}
