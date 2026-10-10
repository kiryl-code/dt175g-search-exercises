package se.miun.dt175g.search.algorithms;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import se.miun.dt175g.search.Node;
import se.miun.dt175g.search.Problem;
import se.miun.dt175g.search.SearchAlgorithm;

public class BreadthFirstTreeSearch<S,A> implements SearchAlgorithm<S,A> {

    @Override
    public Optional<Node<S,A>> solve(Problem<S,A> searchProblem) {
        Queue<Node<S,A>> frontier = new LinkedList<>();
        frontier.add(searchProblem.getInitialNode());
        // TODO: Implement search loop

        while(!frontier.isEmpty()) {
            Node<S,A> node = frontier.remove();
            System.out.println(node.state.toString());
            if (searchProblem.isGoal(node)) {
                return Optional.of(node);
            }
            frontier.addAll(searchProblem.successorsOf(node));
        }
        return Optional.empty();
    }
}
