# Implementing Search Algorithms

This guide explains how to implement different search algorithms using the framework.

## Learning Progression

The recommended order for implementing search algorithms is:

1. **Understand Tree vs Graph Search** (provided implementations)
   - Study `DepthFirstTreeSearch.java`
   - Compare with `DepthFirstGraphSearch.java`

2. **Implement Breadth-First Search**
   - Create your own `BreadthFirstTreeSearch.java`
   - Use Queue instead of Stack for frontier
   - Learn basic search algorithm structure

3. **Add Graph Search Capabilities**
   - Create `BreadthFirstGraphSearch.java`
   - Learn about cycle detection
   - Understand the role of the explored set

4. **Progress to Cost-Aware Search**
   - Work with `UniformCostSearch.java` skeleton
   - Learn to use PriorityQueue with comparators
   - Understand path cost considerations

5. **Implement Informed Search**
   - Build upon your UCS implementation
   - Use provided heuristic integration in `AStarGraphSearch.java`
   - Understand f(n) = g(n) + h(n)

## Common Search Algorithm Patterns

All search algorithms follow a general pattern:
1. Initialize the frontier (with appropriate data structure)
2. Add initial node
3. Loop until solution found or frontier empty
4. Return solution or empty

## Types of Search Algorithms

### 1. Uninformed Search
These algorithms don't use any additional information about states:

#### Breadth-First Search
- Uses Queue for frontier (FIFO)
- Explores all nodes at current depth before going deeper
- Guarantees shortest path in unweighted graphs

```java
// Key components needed:
Queue<Node<S,A>> frontier = new LinkedList<>();
// Optional for graph search:
Set<S> explored = new HashSet<>();
```

#### Uniform Cost Search
- Uses PriorityQueue ordered by path cost g(n)
- Explores lowest-cost nodes first
- Guarantees optimal solution

```java
// Key components needed:
Comparator<Node<S,A>> nodeComparator = // compare by pathCost
PriorityQueue<Node<S,A>> frontier = // use nodeComparator
Set<S> explored = // track visited states
```

### 2. Informed Search
These algorithms use additional information (heuristics):

#### A* Search
- Extends UCS by adding heuristic estimate
- Uses f(n) = g(n) + h(n)
- Optimal when heuristic is admissible

```java
// Key addition to UCS:
Comparator<Node<S,A>> nodeComparator = (a,b) -> 
    Double.compare(a.pathCost + heuristic.apply(a.state),
                  b.pathCost + heuristic.apply(b.state));
```

## Implementation Tips

1. **Start Simple**
   - First implement UCS without the explored set
   - Then add cycle detection
   - Finally add heuristic for A*

2. **Common Pitfalls**
   - Forgetting to check explored states
   - Incorrect comparator implementation
   - Not handling frontier updates

3. **Testing Strategy**
   - Start with Romania travel problem
   - Test with small, known solutions first
   - Compare results with provided implementations