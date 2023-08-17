### Touring Romania Lab

In this exercise you will implement the A\* algorithm and solve a problem that
has become a classic in AI - how do you find the quickest route to Bucharest?
You will then experiment with different heuristics.

The `se.miun.dt175g.search.problems.romania` package contains

- TouringRomania
- City
- DriveAction
- RomaniaHeuristics
- TestTouring

`City` is an enum of all the cities (`City.ARAD`). DriveAction is a class
that holds two cities: `action.from` and `action.to`.

**Your task is to create an implementation of `SearchAlgorithms` that,
at least, overrides `astarTree()` and returns an implementation of
the A\* tree search algorithm.**

You can start from the provided code (`AStarGraphSearch.java`) available in the package `se.miun.dt175g.search.algorithms`,
or you can make it from scratch. If making it from scratch, either scrap the code in the java-file or make sure that
`public SearchAlgorithm<S, A> astarGraph(Heuristic<S> h)` in `se.miun.dt175g.search.algorithms` returns your class.

**BEFORE** implementing the A\* algorithm, you should run it manually
to determine what the solution you expect looks like. In particular,
run it for a couple of different starting points and then compare the
results to what your implementation produces.

`Heuristics` contains a few different heuristics:

- `Heuristics.STRAIGHT_LINE_DISTANCE_HEURISTIC`
- `Heuristics.MANHATTAN_DISTANCE_HEURISTIC`
- `Heuristics.MIN_NODES_TRAVERSED_HEURISTIC`

The first is the one that is used in the book when explaining the algorithm.
You are encouraged to experiment with the others as well, and see
how they perform. You should try to predict what to expect before running them.
If you want to examine a heuristic directly, you can call
`heuristic.estimatedCostAt(city)`.


#### Straight-Line Distance

This is the example heuristic from the book. It uses the distance you would
need to travel if you could fly (or drive in a straight line).


#### Manhattan

This heuristic adds the distances in longitude and latitude. For example,
for Arad the value is 720+250.


#### Min Nodes Traversed

This heuristic counts the minimum number of nodes (cities) that must be
traversed. For example, for Arad the value is 3.


## Questions

#### Heuristics

Consider each of the heuristics in the Touring Romania exercise, and try to
answer these questions (preferably before experimenting with them in practice):

- What is good/bad about it?
- Will it allow A\* to find a solution?
- If so, will it find the cheapest solution?

- For which ones does the usefulness of the heuristic depend on the start
  and/or goal?
- Try to rank them in order of best to worst.


#### Graph Search vs Tree Search

Graph search is generally more efficient than tree search. (Is it always?)
Can you always swap in a graph search version of an algorithm instead of the
tree search version of the same algorithm? What about different algorithms?
