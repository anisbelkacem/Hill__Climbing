package de.uni_passau.fim.se2.se.hillclimbing;

import java.util.List;

/** Fitness function for the hill climbing algorithm. */
public class FitnessFunction {

  /**
   * Calculates the makespan of a schedule.
   *
   * @param schedule the schedule to calculate the makespan for
   * @return the makespan of the schedule
   */
  int calculateMakespan(List<List<Integer>> schedule) {
    int maxSum = 0;
    for (List<Integer> machineJobs : schedule) {
      int currentSum = 0;
      for (Integer job : machineJobs) {
        currentSum += job;
      }
      if (currentSum > maxSum) {
        maxSum = currentSum;
      }
    }

    return maxSum;

    // throw new UnsupportedOperationException("Implement me");
  }
}
