package se.miun.dt175g.search.algorithms;

import se.miun.dt175g.search.Heuristic;
import se.miun.dt175g.search.SearchAlgorithm;

public class ImplementedSearchAlgorithms<S, A> implements SearchAlgorithms<S, A> {

	@Override
	public SearchAlgorithm<S, A> dfsTree() {
		return new DepthFirstTreeSearch<S, A>();
	}

	@Override
	public SearchAlgorithm<S, A> dfsGraph() {
		return new DepthFirstGraphSearch<S, A>();
	}

	// TODO: Implement A* Search
	@Override
	public SearchAlgorithm<S, A> astarGraph(Heuristic<S> h) {
		return new AStarGraphSearch<S, A>(h);
	}

	@Override
	public SearchAlgorithm<S,A> bfsGraph() {
		return new BreadthFirstGraphSearch<S, A>();
	}

}
