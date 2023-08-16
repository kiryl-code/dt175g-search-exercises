package se.miun.dt175g.search.problems.eightpuzzle;

import se.miun.dt175g.search.Heuristic;

/**
 * @author Peter Bergh
 */

public class PuzzleHeuristicManhattan implements Heuristic<Puzzle> {

    // Implement manhattan distance
	@Override
	public double estimatedCostAt(Puzzle state) {
		return 0;
	}
}
