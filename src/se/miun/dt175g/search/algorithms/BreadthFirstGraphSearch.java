package se.miun.dt175g.search.algorithms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;
import se.miun.dt175g.search.Node;
import se.miun.dt175g.search.Problem;
import se.miun.dt175g.search.SearchAlgorithm;

public class BreadthFirstGraphSearch<S,A> implements SearchAlgorithm<S,A> {
    @Override
    public Optional<Node<S,A>> solve(Problem<S,A> searchProblem) {
        System.out.println("BFS Graph Search");
        Queue<Node<S,A>> frontier = new LinkedList<>();
        // Hint: You'll need a Set to keep track of explored states
        Set<S> explored = new HashSet<>();

        frontier.add(searchProblem.getInitialNode());
        explored.add(searchProblem.getInitialNode().state);
        // TODO: Implement search loop with cycle detection
        while(!frontier.isEmpty()) {
            Node<S,A> node = frontier.remove();
            if (searchProblem.isGoal(node)) {
                return Optional.of(node);
            }
            explored.add(node.state);

            for (Node<S, A> successor : searchProblem.successorsOf(node)) {
                if (!explored.contains(successor.state)) {
                    frontier.add(successor);
                }
            }
        }
        return Optional.empty();
    }
}
