package se.miun.dt175g.search.algorithms;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.Stack;

import se.miun.dt175g.search.Node;
import se.miun.dt175g.search.Problem;
import se.miun.dt175g.search.SearchAlgorithm;

public class DepthFirstGraphSearch<S, A> implements SearchAlgorithm<S, A> {

	@Override
	public Optional<Node<S, A>> solve(Problem<S, A> searchProblem) {
		System.out.println("Solving (depth first graph)...");

		Stack<Node<S, A>> frontier = new Stack<>();
		Set<S> explored = new HashSet<>();

		frontier.add(searchProblem.getInitialNode());

		boolean done = false;
		while (!done) {
			if (frontier.isEmpty()) {
				System.out.println("...Failure");
				done = true;
			} else {

				Node<S, A> next = frontier.pop();

				// System.out.println(next.state.toString());

				if (searchProblem.isGoal(next)) {
					return Optional.of(next);
				}

				explored.add(next.state);

				for (Node<S, A> child : searchProblem.successorsOf(next)) {
					if (!explored.contains(child.state) && !frontier.contains(child)) {
						frontier.add(child);
					}
				}
			}
		}

		return Optional.empty();
	}
}