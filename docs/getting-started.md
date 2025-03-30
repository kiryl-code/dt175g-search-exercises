# Getting Started Guide

This guide will help you understand how to use and extend the search framework.

## Understanding the Existing Implementations

Let's examine the provided Depth-First Search implementations to understand how search algorithms work in this framework.

### 1. Tree Search vs Graph Search

The framework provides two DFS implementations:
- `DepthFirstTreeSearch`: Basic tree search without cycle detection
- `DepthFirstGraphSearch`: Enhanced version that prevents revisiting states

Key differences:
- Tree search uses only a frontier (Stack)
- Graph search adds an explored set (HashSet)
- Graph search is typically more efficient but uses more memory

### 2. Analyzing the Components

Let's break down the key parts of these implementations:

1. **Frontier Management**
   - Both use `Stack<Node<S,A>>` for LIFO behavior
   - Nodes are popped from top for depth-first exploration

2. **State Tracking**
   - Tree search: Only checks frontier
   - Graph search: Maintains explored set using `HashSet<S>`

3. **Goal Testing**
   - Both check goals using `searchProblem.isGoal(node)`
   - Return `Optional.of(node)` when goal found

### 3. Running a Search

Here's how to use the existing implementations:

```java
// Create the Romania problem (Arad to Bucharest)
TouringRomania problem = new TouringRomania(ARAD, BUCHAREST);

// Create search algorithm instance
ImplementedSearchAlgorithms<City, DriveAction> searchAlgorithms = 
    new ImplementedSearchAlgorithms<>();

// Run depth-first graph search
Optional<Node<City, DriveAction>> solution = 
    searchAlgorithms.dfsGraph().solve(problem);
```

## Exercises

1. **Compare Implementations**
   - Run both tree and graph search on the Romania problem
   - Count how many states each version explores
   - Observe differences in the solutions found

2. **Modify the Output**
   - Add counters to track nodes explored
   - Print the current search depth
   - Visualize the frontier's contents

3. **Create Your Own Problem**
   - Implement the Problem interface
   - Define states and actions
   - Test with existing search algorithms
