### Eight Puzzle

This problem, much like the Touring Romania problem, is already defined for you.
This exercise assumes that you have a functional implementation of the `A*` algorithm in place.
You can, of course, attempt it with other search methods as well. Bear in mind that any type of tree search
has a high probability of running indefinitely, so I discourage you from relying on that approach.

The aim of this package is to provide you with an opportunity to create an effective heuristic function.
The heuristic for the Touring Romania problem is static, as cities don't typically move between locations,
at least not between actions :-)
However, in the case of the eight puzzle, we can't rely on static knowledge in the same way.
Read section `3.6 Heuristic Functions` to familiarize yourself with the context.



