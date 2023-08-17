package se.miun.dt175g.search.problems.romania;

import se.miun.dt175g.search.Node;
import se.miun.dt175g.search.algorithms.ImplementedSearchAlgorithms;
import static se.miun.dt175g.search.problems.romania.City.*;
import java.util.Optional;


public class TestTouring {

	public static void main(String[] args) {
		
		
		TouringRomania tr = new TouringRomania(ARAD, BUCHAREST);
		ImplementedSearchAlgorithms<City, DriveAction> isa = new ImplementedSearchAlgorithms<>();
		Optional<Node<City, DriveAction>> opt = isa.dfsGraph().solve(tr);
	
		if(!opt.isEmpty()) {
			Node<City, DriveAction> solution = opt.get();
			System.out.println("Solution Path: " + solution.getActions());
			System.out.println("Total Cost: " + solution.pathCost);
			System.out.println("Total depth: " + solution.depth);
		}
		else {
			System.out.println("Couldn't find a solution to problem.");
		}
		
		ImplementedSearchAlgorithms<City, DriveAction> isa2 = new ImplementedSearchAlgorithms<>();
		Optional<Node<City, DriveAction>> opt2 = isa2.astarGraph(RomaniaHeuristics.getStraightLineDistanceHeuristic()).solve(tr);
	
		if(!opt2.isEmpty()) {
			Node<City, DriveAction> solution = opt2.get();
			System.out.println("Solution Path: " + solution.getActions());
			System.out.println("Total Cost: " + solution.pathCost);
			System.out.println("Total depth: " + solution.depth);
		}
		else {
			System.out.println("Couldn't find a solution to problem.");
		}

	}

}
