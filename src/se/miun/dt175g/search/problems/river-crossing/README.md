### River Crossing

This exercise consists of two parts. In the first part, you are given a
complete problem definition and asked to reason about how to solve it
(which algorithms might be more or less suitable). In the second part,
you are asked to create a definition of a related problem.

The river crossing puzzle exists in many variations.  The "missionaries and
cannibals" version is already defined for you. Before looking at the code, you
should think about how you might define that problem. Then try to answer the
questions below and experiment with solving it using different search
algorithms.

Another variation is the "fox, goose, and bag of beans" version. A farmer
is trying to get a fox, a goose, and a bag of beans across a river, but the
boat can only carry her and one of the items. If the fox is left alone with
the goose, there will be a mess. Similarly, the goose will try to eat the
beans. So how can the farmer move the items one at a time so that all three
end up on the other side of the river intact?

Your problem definition should be an implementation of the `Problem`
interface.

Note a key difference between the two versions: in the "missionaries and
cannibals" version, any of the "items" can drive the boat; in the "fox, goose,
and bag of beans" version, only the farmer can drive.

You should of course consider the questions below for this second version
as well. Don't forget to discuss them with each other on the forum.


### Questions (Missionaries and Cannibals version)

Think about the properties of this problem and what that means for the search
algorithm. Which do you suspect work better or worse for this particular problem?

- How large is the state space? (To simplify things, ignore the safety/legality
  of the states - given the number of people and the number of places the boat
  can be, what are all the possible states?)
- How many times does the boat have to cross the river in the shortest solution?
- Is there a unique shortest solution?
- What is the longest possible solution?
- What are the advantages/disadvantages of different search algorithms?
  How did you decide which algorithm to use?
- Can you put an upper limit on the maximum number of goal tests **your**
  algorithm must perform?
- What happens if you don't check whether a state is repeated/already exists
  in your partial solution? In other words, if you don't check for cycles.


### Extra credit (well, you won't actually get any credits, but you will get a [feeling of accomplishment](https://www.youtube.com/watch?v=gADVJDW7WTw&feature=youtu.be&t=50s))

The definition of "missionaries and cannibals" uses enumerated states and
actions, which is possible because the state space is quite small, and the
actions are very limited. This might feel a little bit like cheating, as though
a lot of the work has already been done beforehand. Using this as an example,
you may be tempted to use the same strategy for the "fox, goose, and bag of
beans" problem as well. The same strategy will certainly not work for N-Queens
or the sliding block puzzle (unless you go for a 3-puzzle). So if you take on
defining any of those, then you will have to define states more generally than
this. So if you want an excuse to redefine the "missionaries and cannibals"
problem, here's a challenge for you. Define a general version where you have
to move `n` missionaries and `n` cannibals. What is the largest number `n` for
which the problem is solvable? (In the standard definition, `n = 3`.)


### Missionaries and Cannibals (details, optional)

Here is a more detailed description of this version, in case you are interested.

You're trying to get 6 people across a river; 3 missionaries and 3 cannibals.
The boat can carry at most two people at a time. The catch is that the
cannibals must never outnumber the missionaries on one side of the river.

[Here's a game where you can try to solve this puzzle](http://www.learn4good.com/kids-games/puzzle/boat.htm).
