package se.miun.dt175g.search.problems.river;

import java.util.Collection;
import java.util.EnumSet;

import se.miun.dt175g.search.AbstractSearchProblem;



/**
 * A definition of the "missionaries and cannibals" version of the river
 * crossing problem.
 * @author Christoffer Fink
 */
public class MissionariesAndCannibals extends
    AbstractSearchProblem<MissionariesAndCannibals.State, MissionariesAndCannibals.Action> {

  /** All the possible actions (may not be applicable in some states). */
  public enum Action {

    MOVE_0_2(0,2),  // Move 0 missionaries and 2 cannibals.
    MOVE_2_0(2,0),
    MOVE_1_1(1,1),
    MOVE_0_1(0,1),
    MOVE_1_0(1,0);

    public final int missionaries;
    public final int cannibals;

    private Action(int m, int c) {
      this.missionaries = m;
      this.cannibals = c;
    }
  }

  /** All the possible (safe) states. */
  public enum State {

    M3C3B1(3, 3, true), // Everything is on the left side.
    M3C2B1(3, 2, true),
    M3C1B1(3, 1, true),
    M3C0B1(3, 0, true),
    M2C2B1(2, 2, true),
    M1C1B1(1, 1, true),
    M0C3B1(0, 3, true),
    M0C2B1(0, 2, true),
    M0C1B1(0, 1, true),
    M3C2B0(3, 2, false),
    M3C1B0(3, 1, false),
    M3C0B0(3, 0, false),
    M2C2B0(2, 2, false),
    M1C1B0(1, 1, false),
    M0C3B0(0, 3, false),
    M0C2B0(0, 2, false),
    M0C1B0(0, 1, false),
    M0C0B0(0, 0, false); // Everything is on the right side.

    public final int missionariesLeft;
    public final int cannibalsLeft;
    public final boolean boatLeft;

    private State(int missionaries, int cannibals, boolean boat) {
      this.missionariesLeft = missionaries;
      this.cannibalsLeft = cannibals;
      this.boatLeft = boat;
    }
  }

  private State result(State s, Action move) {
    // What would the new state look like?
    boolean b = !s.boatLeft;
    int m = s.missionariesLeft + move.missionaries * (b ? 1 : -1);
    int c = s.cannibalsLeft + move.cannibals * (b ? 1 : -1);

    // Which, if any, of the possible states does it match?
    for (State t : State.values()) {
      if (t.missionariesLeft == m && t.cannibalsLeft == c && t.boatLeft == b) {
        return t;
      }
    }
    return null;
  }

  /**
   * Create an instance where the problem is getting 3 of each from the left
   * side to the right side.
   */
  public MissionariesAndCannibals() {
    super(State.M3C3B1, State.M0C0B0);
  }

  @Override
  public Collection<Action> possibleActionsIn(State state) {
    Collection<Action> actions = EnumSet.noneOf(Action.class);
    for (Action action : Action.values()) {
      State after = result(state, action);
      if (after != null) {
        actions.add(action);
      }
    }
    return actions;
  }

  @Override
  public State transition(State state, Action action) {
    State result = result(state, action);
    if (result == null) {
      throw new IllegalArgumentException("No transition for " + action + " in " + state + ".");
    }
    return result;
  }

}
