package se.miun.dt175g.search;

/**
 * Maps actions to cost.
 *
 * @author Christoffer Fink
 */
@FunctionalInterface
public interface CostFunction<A> {

  public double costOf(A action);
}
