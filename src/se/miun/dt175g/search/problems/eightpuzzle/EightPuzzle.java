package se.miun.dt175g.search.problems.eightpuzzle;

import static se.miun.dt175g.search.problems.eightpuzzle.Direction.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import se.miun.dt175g.search.AbstractSearchProblem;
import se.miun.dt175g.search.util.Point;

/**
 * @author Peter Bergh
 */

public class EightPuzzle extends AbstractSearchProblem<Puzzle, Direction> {

	private static final Map<Point, Collection<Direction>> actionMap;
	static {
		Map<Point, Collection<Direction>> aMap = new HashMap<>();
		aMap.put(new Point(0, 0), Collections.unmodifiableCollection(Arrays.asList(RIGHT, DOWN)));
		aMap.put(new Point(1, 0), Collections.unmodifiableCollection(Arrays.asList(RIGHT, DOWN, LEFT)));
		aMap.put(new Point(2, 0), Collections.unmodifiableCollection(Arrays.asList(DOWN, LEFT)));
		aMap.put(new Point(0, 1), Collections.unmodifiableCollection(Arrays.asList(UP, DOWN, RIGHT)));
		aMap.put(new Point(1, 1), Collections.unmodifiableCollection(Arrays.asList(UP, DOWN, RIGHT, LEFT)));
		aMap.put(new Point(2, 1), Collections.unmodifiableCollection(Arrays.asList(UP, DOWN, LEFT)));
		aMap.put(new Point(0, 2), Collections.unmodifiableCollection(Arrays.asList(UP, RIGHT)));
		aMap.put(new Point(1, 2), Collections.unmodifiableCollection(Arrays.asList(UP, RIGHT, LEFT)));
		aMap.put(new Point(2, 2), Collections.unmodifiableCollection(Arrays.asList(UP, LEFT)));
		actionMap = Collections.unmodifiableMap(aMap);
	}

	public EightPuzzle(Puzzle start, Puzzle goal) {
		super(start, goal);
	}

	

	@Override
	public Collection<Direction> possibleActionsIn(Puzzle state) {
		return actionMap.get(state.getBlankSpace());
	}

	@Override
	public Puzzle transition(Puzzle state, Direction action) {
		Puzzle trans = null;
		try {
			trans = (Puzzle) state.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		trans.slide(state.getBlankSpace(), action);
		return trans;
		
		
	}

}
