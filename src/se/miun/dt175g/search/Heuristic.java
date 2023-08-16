package se.miun.dt175g.search;

import java.util.function.Function;

/**
 * Maps states to (estimated) cost.
 *
 * @author Christoffer Fink
 */
@FunctionalInterface
public interface Heuristic<State> extends Function<State, Double> {

  @Override
  public default Double apply(State state) {
    return estimatedCostAt(state);
  }

  public double estimatedCostAt(State state);
}
