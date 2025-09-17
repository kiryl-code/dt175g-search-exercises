package se.miun.dt175g.search.algorithms;

import java.util.Optional;
import java.util.Stack;
import se.miun.dt175g.search.Node;
import se.miun.dt175g.search.Problem;
import se.miun.dt175g.search.SearchAlgorithm;

public class DepthFirstTreeSearch<S, A> implements SearchAlgorithm<S, A> {

	@Override
	public Optional<Node<S, A>> solve(Problem<S, A> searchProblem) {
		System.out.println("Solving (depth first tree)...");

		Stack<Node<S, A>> frontier = new Stack<>();

		frontier.add(searchProblem.getInitialNode());

		boolean done = false;
		while (!done) {
			if (frontier.isEmpty()) {
				System.out.println("...Failure");
				done = true;
			} else {

				Node<S, A> next = frontier.pop();

				// Beware of loopy paths...
				System.out.println(next.state.toString());

				if (searchProblem.isGoal(next)) {
					return Optional.of(next);
				}

				/*
				 * Possible optional thing:
				 * An "explored" set is not relevant for tree search. However, we can add the
				 * "inFrontier" set that is in DepthFirstGraphSearch if we want, to avoid
				 * possible duplicates. If you want to avoid it going directly back to the
				 * parent (as we will see examples of in our lecture) then add a check that
				 * prevents the parent from being added
				 */
				for (Node<S, A> child : searchProblem.successorsOf(next)) {
					frontier.add(child);
				}
			}
		}

		return Optional.empty();
	}
}