### LO2 Exercises, general info

In the provided libraries, you will find a few useful tools:

- Interfaces:
  - Problem
  - SearchAlgorithm
  - InformedSearchAlgorithm
  - SearchAlgorithm**s**
- Classes:
  - Node
  - AbstractSearchProblem
- Problem definitions:
  - Missionaries and cannibals
  - Touring romania
- Utilities
  - InstrumentedProblem
  - Problem.Builder
  - SuccessorFunction.from(...)

These are all reasonably well documented. So you should see the comments
(and, if necessary, the code) for details. But briefly, the `Problem` interface
is what your problem definition should implement. It also contains a builder
which can be used to help define a concrete problem. Another way to define a
problem is to extend `AbstractSearchProblem` and override as few as two
method, depending on the nature of the problem. Whether `Problem.builder()`
or `extends AbstractSearchProblem` is more convenient partly depends on the
problem and partly on your preferred programming style.

There are two examples of problem definitions which can serve as examples.
These are covered in more detail in the respective exercise.

A `SearchAlgorithm` just takes a `Problem` and returns a solution `Node`.
You can get a list of actions, which is usually what you are actually
interested in, by calling `node.getActions()`. (The reason a search algorithm
returns a node rather than a list of actions is that you then get some
bookkeeping info for free, such as the path length (`node.depth`) and cost
(`node.pathCost`).

An `InformedSearchAlgorithm` additionally takes a `Heuristic`. The interface
also has a little utility function (`curry(algorithm, heuristic)`) for fixing a
heuristic.

The `SearchAlgorithms` (plural!) interface is where you come in. The exercise
for this learning object consists of implementing as many search algorithms and
problems as possible, and, perhaps most importantly, experimenting with them.
My advice is to collaborate as much as possible and build up a library together
by sharing implementations with each other.

The class `ImplementedSearchAlgorithms`, which you find in the `algorithms` package, implements
`SearchAlgorithms`. The methods `dfsTree`, `dfsGraph`, and `astarGraph` have already been overridden
there. However, only the first two mentioned methods are fully implemented. The `astarGraph` method returns
an instance of `AStarGraphSearch`, which isn't yet functional.

At a minimum, you should implement `A*` yourself because it's a particularly
important algorithm. However, to minimize the risk of a frustrating experience,
I would recommend starting by implementing `Breadth-First Search (graph version)`, and then
proceeding with `Uniform-Cost Search (graph version)`. This would offer a more natural
progression for understanding `A*`, in my opinion.

Note that defining problems is as important as implementing the algorithms that
are supposed to solve them. In the "river crossing" exercise, you will be asked
to do just that.

Other suggestions for problems you should try to define are:

- N-Queens
- ~~8-puzzle (or any other size)~~ (already given, implement Manhattan Distance for 8-puzzle instead)

I suggest you start with N-Queens, since the sliding block puzzles can be a bit
tricky. (Why?)

*N-queens* is solvable using the strategies presented in chapters 3, 4, and 5.
I recommend trying it for each of these chapters, as it can be a highly educational experience
to observe the time it takes to solve a 1000-Queens problem based on the algorithm.

Again, share definitions with each other so you have as many combinations of
problems and algorithms as possible to experiment with.


#### Utilities

I've already mentioned `Problem.Builder`. The related `SuccessorFunction.from`
method makes it easy to construct a `SuccessorFunction` from a `CostFunction`,
`TransitionFunction`, and `ActionsFunction`.

An `InstrumentedProblem` is a decorator that allows you to get some stats about
how the search algorithm uses the problem, such as the order (and number) of
node expansions and goal tests.
