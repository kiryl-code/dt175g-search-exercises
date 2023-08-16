package se.miun.dt175g.search.problems.romania;

import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import se.miun.dt175g.search.AbstractSearchProblem;
import static se.miun.dt175g.search.problems.romania.City.*;
import static java.util.stream.Collectors.groupingBy;


/**
 * A definition of the Touring Romania problem from
 * Artificial Intelligence - A Modern Approach, by Russel and Norvig.
 * @author Christoffer Fink
 */
public class TouringRomania extends AbstractSearchProblem<City,DriveAction> {

  private static final Map<DriveAction,Double> costMap = new HashMap<>();
  private static final Map<City,Collection<DriveAction>> actionMap;

  static {
    add(ARAD, SIBIU, 140);
    add(ARAD, TIMISOARA, 118);
    add(ARAD, ZERIND, 75);
    add(BUCHAREST, FAGARAS, 211);
    add(BUCHAREST, GIURGIU, 90);
    add(BUCHAREST, PITESTI, 101);
    add(BUCHAREST, URZICENI, 85);
    add(CRAIOVA, DROBETA, 120);
    add(CRAIOVA, PITESTI, 138);
    add(CRAIOVA, RIMNICU_VILCEA, 146);
    add(DROBETA, MEHADIA, 75);
    add(EFORIE, HIRSOVA, 86);
    add(FAGARAS, SIBIU, 99);
    add(HIRSOVA, URZICENI, 98);
    add(IASI, NEAMT, 87);
    add(IASI, VASLUI, 92);
    add(LUGOJ, MEHADIA, 70);
    add(LUGOJ, TIMISOARA, 111);
    add(ORADEA, SIBIU, 151);
    add(ORADEA, ZERIND, 71);
    add(PITESTI, RIMNICU_VILCEA, 97);
    add(RIMNICU_VILCEA, SIBIU, 80);
    add(URZICENI, VASLUI, 142);

    actionMap = new EnumMap<>(costMap.keySet().stream().collect(groupingBy(DriveAction::getFrom)));
  }

  private static void add(City c1, City c2, double cost) {
    costMap.put(DriveAction.of(c1, c2), cost);
    costMap.put(DriveAction.of(c2, c1), cost);
  }

  /** 
   * Create an instance where the problem is getting from the starting city to
   * the goal city.
   */
  public TouringRomania(City start, City goal) {
    super(start, goal);
  }

  @Override
  public double costOf(DriveAction action) {
    return costMap.get(action);
  }

  @Override
  public City transition(City current, DriveAction action) {
    return action.to;
  }

  @Override
  public Collection<DriveAction> possibleActionsIn(City current) {
    return actionMap.get(current);
  }

}
