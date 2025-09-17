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
		Set<S> inFrontier = new HashSet<>(); // NEW


		Node<S, A> initial = searchProblem.getInitialNode();
		frontier.push(initial);
		inFrontier.add(initial.state); // NEW


		boolean done = false;
		while (!done) {
			if (frontier.isEmpty()) {
				System.out.println("...Failure");
				done = true;
			} else {

				Node<S, A> next = frontier.pop();
            	inFrontier.remove(next.state); // NEW

				if (searchProblem.isGoal(next)) {
					return Optional.of(next);
				}

				explored.add(next.state);

				for (Node<S, A> child : searchProblem.successorsOf(next)) {
					if (!explored.contains(child.state) && !inFrontier.contains(child.state)) {
						frontier.add(child);
						inFrontier.add(child.state);
					}
				}
			}
		}

		return Optional.empty();
	}
}