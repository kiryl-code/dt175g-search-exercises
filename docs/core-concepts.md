# Core Concepts Guide

This guide explains the fundamental components of the search framework. Read this first to understand the basic building blocks.

## SearchAlgorithm Interface

The `SearchAlgorithm` interface is the heart of the framework. It defines a single method that all search algorithms must implement:

```java
public interface SearchAlgorithm<S,A> {
    Optional<Node<S,A>> solve(Problem<S,A> searchProblem);
}
```

- `S`: The type parameter representing the State
- `A`: The type parameter representing the Action
- Returns an `Optional<Node>` containing the solution if found

## Problem Interface

The `Problem` interface defines what constitutes a search problem:

```java
public interface Problem<S,A> {
    Node<S,A> getInitialNode();
    boolean isGoal(Node<S,A> node);
    Collection<Node<S,A>> successorsOf(Node<S,A> node);
}
```

### Key Components:
1. `getInitialNode()`: Starting point of the search
2. `isGoal()`: Determines if a given node is a solution
3. `successorsOf()`: Generates next possible states

## Node Class

The `Node` class represents a point in the search space:

```java
public class Node<S,A> {
    public final S state;          // Current state
    public final Node<S,A> parent; // Parent node
    public final A action;         // Action that led here
    public final double pathCost;  // Cost from start to here
    public final int depth;        // Steps from initial state
}
```

## Search Algorithm Categories

1. **Tree vs Graph Search**
   - Tree: May revisit states
   - Graph: Maintains explored set to avoid cycles

2. **Uninformed vs Informed Search**
   - Uninformed: No extra information (DFS, BFS, UCS)
   - Informed: Uses heuristics (A*, Greedy Best-First)

Next, read the "Getting Started Guide" to see these concepts in action.
