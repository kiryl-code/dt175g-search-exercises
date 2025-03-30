# Getting Started Guide

After understanding the core concepts, this guide will show you how to use the existing implementations.

## Available Implementations

The framework provides these search algorithms:

1. **Depth-First Search**
   - `DepthFirstTreeSearch`: Basic tree search version
   - `DepthFirstGraphSearch`: Version with cycle detection

## Running Your First Search

Let's use the Romania travel problem:

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

## Understanding the Output

When you run a search, you'll see:
- States being explored
- Solution path (if found)
- Path cost and depth information

## Available Problems

1. **Romania Travel Problem**
   - Classic path-finding problem
   - Cities connected by roads
   - Different path costs

2. **8-Puzzle Problem**
   - Sliding tile puzzle
   - More complex state space
   - Good for testing different algorithms

3. **River Crossing Problem**
   - Logic puzzle
   - Multiple valid solutions

Next, proceed to "Implementing Search Algorithms" to create your own algorithms.
