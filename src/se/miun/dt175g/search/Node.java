package se.miun.dt175g.search;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a node in a search graph/tree.
 * Only the root node can be created from scratch. Child nodes can only be
 * created by deriving a successor of an existing node.
 * <p>
 * Nodes are comparable by path cost.
 *
 * @author Christoffer Fink
 */
public final class Node<S,A> implements Comparable<Node<S,A>> {

  /** The parent (predecessor) node - doesn't exist for the root. */
  public final Node<S,A> parent;
  public final S state;
  public final A action;
  public final double pathCost;
  public final int depth;

  public static <S,A> Node<S,A> root(S state) {
    if (state == null) {
      throw new IllegalArgumentException("Null states not allowed.");
    }
    return new Node<>(null, state, null, 0, 0);
  }

  private Node(Node<S,A> parent, S state, A action, double pathCost, int depth) {
    this.parent = parent;
    this.state = state;
    this.action = action;
    this.pathCost = pathCost;
    this.depth = depth;
  }

  public boolean isRoot() {
    return parent == null;
  }

  public Node<S,A> successor(S state, A action, double actionCost) {
    if (state == null) {
      throw new IllegalArgumentException("Null states not allowed.");
    }
    if (action == null) {
      throw new IllegalArgumentException("Null actions not allowed.");
    }
    return new Node<>(this, state, action, pathCost + actionCost, depth + 1);
  }

  public double getActionCost() {
    return pathCost - (isRoot() ? 0 : parent.pathCost);
  }

  public List<A> getActions() {
    if (isRoot()) {
      return new ArrayList<>();
    } else {
      List<A> actions = parent.getActions();
      actions.add(action);
      return actions;
    }
  }

  @Override
  public String toString() {
    return "Node(state: " + state + ", action: " + action + ", pathCost: "
      + pathCost + ", parent: " + parent + ")";
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Node)) {
      return false;
    }
    Node<?,?> that = (Node) o;
    if (this.depth != that.depth) {
      return false;
    }
    if (this.pathCost != that.pathCost) {
      return false;
    }
    if (!this.state.equals(that.state)) {
      return false;
    }
    // Only parent left to check.
    if (this.isRoot()) {
      return that.isRoot();
    }
    return this.parent.equals(that.parent);
  }

  @Override
  public int hashCode() {
    int hash = state.hashCode();
    if (action != null) {
      hash ^= action.hashCode();
    }
    return hash + depth + (int) pathCost;
  }

  @Override
  public int compareTo(Node<S,A> other) {
    return Double.compare(this.pathCost, other.pathCost);
  }

}
