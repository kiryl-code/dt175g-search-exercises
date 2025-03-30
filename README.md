# Search Algorithm Learning Framework

Welcome to the Search Algorithm Learning Framework! This educational package is designed to help you understand and implement various search algorithms commonly used in artificial intelligence and computer science.

## 🎯 Learning Objectives

By working with this framework, you will learn to:
- Understand core search algorithm concepts
- Implement different search strategies (DFS, BFS, A*, etc.)
- Compare algorithm performance and characteristics
- Apply search algorithms to solve real problems

## 📚 Core Concepts

The framework is built around these fundamental concepts:

1. **Search Algorithm** (`SearchAlgorithm<S,A>`)
   - An algorithm that finds a solution path from an initial state to a goal state
   - Generic type parameters:
     - S: State type (e.g., City, PuzzleState)
     - A: Action type (e.g., DriveAction, Move)

2. **Problem** (`Problem<S,A>`)
   - Defines the search problem structure:
     - Initial state
     - Goal test
     - Available actions
     - Transition model

3. **Node** (`Node<S,A>`)
   - Represents a point in the search space
   - Contains:
     - Current state
     - Parent node
     - Action that led to this state
     - Path cost

## 🚀 Getting Started

1. **Read the documentation**
   - Read the documentation in the `docs` folder

2. **Start with Tree Search**
   - Look at `DepthFirstTreeSearch.java` for a basic implementation
   - Try running `TestTouring.java` to see it in action

3. **Explore Example Problems**
   - Romania Travel Problem (`problems/romania/`)
   - 8-Puzzle Problem (`problems/eightpuzzle/`)

4. **Implement Your Own**
   - Start with the simpler tree search algorithms
   - Progress to graph search variants
   - Finally tackle informed search with heuristics

## 📝 Exercises

1. **Basic Search Implementation**
   - Complete the implementation of BFS tree search
   - Compare its performance with the provided DFS implementation

2. **Graph Search**
   - Modify tree search to avoid exploring repeated states
   - Implement cycle detection

3. **Informed Search**
   - Implement A* search
   - Design and test different heuristics

## 🗺️ Package Structure

se.miun.dt175g.search/
├── SearchAlgorithm.java # Core search algorithm interface
├── Problem.java # Problem definition interface
├── Node.java # Search tree/graph node
├── algorithms/ # Algorithm implementations
├── problems/ # Example problem domains
└── util/ # Utility classes


## 🤝 Contributing

Found a bug? Have a suggestion? Please open an issue or submit a pull request!

## 📖 Further Reading

- [Artificial Intelligence: A Modern Approach](http://aima.cs.berkeley.edu/)
