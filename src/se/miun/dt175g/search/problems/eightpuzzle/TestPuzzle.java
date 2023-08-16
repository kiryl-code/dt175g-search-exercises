package se.miun.dt175g.search.problems.eightpuzzle;


import java.util.Optional;
import se.miun.dt175g.search.Node;
import se.miun.dt175g.search.algorithms.ImplementedSearchAlgorithms;

/**
 * @author Peter Bergh
 */

public class TestPuzzle {
	
	public static void main(String[] args) {
		
		Integer[] startVal = new Integer[] {7,2,4,5,null,6,8,3,1};
		Integer[] goalVal = new Integer[] {null,1,2,3,4,5,6,7,8};
		
		Puzzle start = new Puzzle(startVal);
		Puzzle goal = new Puzzle(goalVal);
		
		
		EightPuzzle ep = new EightPuzzle(start, goal);
		ImplementedSearchAlgorithms<Puzzle, Direction> isa = new ImplementedSearchAlgorithms<>();
		Optional<Node<Puzzle, Direction>> opt = isa.astarGraph(new PuzzleHeuristicManhattan()).solve(ep);
		
		if(!opt.isEmpty()) {
			Node<Puzzle, Direction> solution = opt.get();
			System.out.println("Solution Path: " + solution.getActions());
			System.out.println("Total Cost: " + solution.pathCost);
		}
		else {
			System.out.println("Couldn't find a solution to problem.");
		}
	}

}
