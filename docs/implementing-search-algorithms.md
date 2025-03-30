# Implementing Search Algorithms

Now that you understand the framework and have used the existing implementations, let's create your own search algorithms.

## Implementation Order

Follow this progression to build your understanding:

1. **Breadth-First Search**
   - Create `BreadthFirstTreeSearch.java`
   - Use Queue for frontier (FIFO)
   - Learn basic search structure
   - Add graph search capabilities in `BreadthFirstGraphSearch.java`

2. **Uniform Cost Search**
   - Work with provided `UniformCostSearch.java` skeleton
   - Implement path cost ordering
   - Understand PriorityQueue usage

3. **A* Search**
   - Build on your UCS implementation
   - Use provided heuristic code in `AStarGraphSearch.java`
   - Learn about informed search

## Implementation Guide

### Breadth-First Search
Start with this structure:

```java
public class BreadthFirstTreeSearch<S,A> implements SearchAlgorithm<S,A> {
    @Override
    public Optional<Node<S,A>> solve(Problem<S,A> searchProblem) {
        Queue<Node<S,A>> frontier = new LinkedList<>();
        frontier.add(searchProblem.getInitialNode());
        // TODO: Implement search loop
    }
}
```

After implementing tree search, create a graph search version:

```java
public class BreadthFirstGraphSearch<S,A> implements SearchAlgorithm<S,A> {
    @Override
    public Optional<Node<S,A>> solve(Problem<S,A> searchProblem) {
        Queue<Node<S,A>> frontier = new LinkedList<>();
        // Hint: You'll need a Set to keep track of explored states
        Set<S> explored = new HashSet<>();
        
        frontier.add(searchProblem.getInitialNode());
        // TODO: Implement search loop with cycle detection
    }
}
```

The key difference is the addition of the explored set to prevent visiting the same state multiple times. This makes the search more efficient in graphs that contain cycles.

### Uniform Cost Search
Use the provided skeleton and implement:
1. Path cost comparator
2. Frontier management
3. Explored set handling

### A* Search
Use the provided skeleton with:
1. The given heuristic comparator
2. Same graph search structure as your UCS
3. Same frontier management approach

Note: A* is essentially UCS where the ordering is based on f(n) = g(n) + h(n) instead of just g(n). The comparator for this is already provided in the skeleton.

## Testing Your Implementations

1. **Start Simple**
   - Use small Romania map instances
   - Verify expected paths are found
   - Compare with existing DFS implementation

2. **Progress to Complex**
   - Test with full Romania map
   - Try 8-puzzle configurations
   - Compare algorithm performance

## Common Implementation Tips

1. **Frontier Management**
   - Always check if frontier is empty
   - Handle duplicate states correctly
   - Use appropriate data structures

2. **State Tracking**
   - Graph search needs explored set
   - Check states, not nodes
   - Handle state equality correctly

3. **Solution Handling**
   - Return Optional.empty() for no solution
   - Verify solution path is complete
   - Check path costs are correct