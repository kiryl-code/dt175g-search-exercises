# Core Concepts Guide

This guide explains the fundamental components of the search framework.

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
    public final S state;      // Current state
    public final Node<S,A> parent; // Parent node
    public final A action;     // Action that led here
    public final double pathCost;  // Cost from start to here
    public final int depth;    // Steps from initial state
}
```

## Understanding the Search Process

1. **Initialization**
   - Create initial node from problem's initial state
   - Add to frontier (the set of nodes to be explored)

2. **Main Loop**
   - Select and remove a node from frontier
   - Test if it's a goal state
   - If not, expand node and add children to frontier

3. **Solution**
   - When goal found, trace back through parent links
   - Return path from initial state to goal

## Example Flow

```
Initial State → [Search Algorithm] → Goal State
      ↓                                   ↑
    Node → Expand → Add to Frontier → Select
            ↑                         |
            └─────────────────────────┘
```

## Common Variations

1. **Tree Search vs Graph Search**
   - Tree: May revisit states
   - Graph: Maintains explored set to avoid cycles

2. **Uninformed vs Informed Search**
   - Uninformed: No extra information (DFS, BFS)
   - Informed: Uses heuristics (A*, Greedy Best-First)

## Next Steps

- Try implementing a simple DFS algorithm
- Experiment with the Romania travel problem
- Compare different search strategies
