# Hill Climbing - Job Scheduling

The **Job Scheduling problem** involves assigning a set of jobs to machines (or processors) such that the total time taken to complete all jobs is minimized. Each job has a specific processing time, and a machine can only process one job at a time. The goal is to minimize the makespan, which is the time by which all jobs have finished executing by distributing the jobs across all available machines in an optimal way.

For example, given jobs = `[1, 2, 3, 4]` and `m = 2`, the optimal distribution of the jobs is `[1, 4]`, `[2, 3]` with a makespan of `5`.

## Problem Solving Approach: Hill Climbing Algorithm

In order to solve the scheduling problem, we employ the **Hill Climbing algorithm** to optimize a job schedule that minimizes the makespan of executing all jobs. Here's how the algorithm works:

1. **Initial Solution**: We start with a randomized solution (random schedule) that distributes all jobs across `m` machines.
2. **Neighbour Generation**: We generate a set of neighbour solutions by moving a single job from one machine to another.
3. **Fitness Function**: The neighbour with the best fitness, based on the makespan, is selected as the new current solution.
4. **Restarting**: If the algorithm reaches a local optimum (no improvement after a set number of iterations), it restarts from a new random solution to escape the local optimum and continue the search.

### Example of a Neighbour Set
For a given schedule like `[1], [2, 3]`, the neighbour solutions are:
- `[]`, `[1, 2, 3]`
- `[1, 2]`, `[3]`
- `[1, 3]`, `[2]`

The Hill Climbing algorithm uses these neighbours and the fitness function to iteratively find the optimal job schedule.

## Files & Implementation

### ScheduleGenerator.java
This file handles generating the randomised job schedule and the set of all possible neighbours by moving jobs between machines.

### FitnessFunction.java
This file implements the `calculateMakespan()` function, which computes the total execution time of a given schedule based on the machines' loads.

### HillClimbing.java
This file implements the Hill Climbing algorithm and integrates random restarts after a pre-defined number of iterations without progress. The `optimize()` method drives the algorithm.


