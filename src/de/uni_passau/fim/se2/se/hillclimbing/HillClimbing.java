package de.uni_passau.fim.se2.se.hillclimbing;

import java.util.ArrayList;
import java.util.List;

/** Hill climbing algorithm with restarts to solve the job scheduling problem. */
public final class HillClimbing {

  private final ScheduleGenerator generator;
  private final FitnessFunction fitnessFunction;

  public HillClimbing(ScheduleGenerator generator, FitnessFunction fitnessFunction) {
    this.generator = generator;
    this.fitnessFunction = fitnessFunction;
  }

  /**
   * Optimize the job scheduling problem using the hill climbing algorithm with restarts.
   *
   * @param jobs the jobs to schedule
   * @param numMachines the number of machines
   * @param maxIterations the maximum number of iterations
   * @param restartThreshold the number of iterations without improvement before a restart is
   *     triggered
   * @return the optimal schedule
   */
  public List<List<Integer>> optimize(
      int[] jobs, int numMachines, int maxIterations, int restartThreshold) {
    if (numMachines == 0 || jobs.length == 0) {
      return new ArrayList<>();
    }
    List<List<Integer>> currentSchedule = generator.generateSchedule(jobs, numMachines);
    int currentMakespan = fitnessFunction.calculateMakespan(currentSchedule);
    int iterationsWithoutImprovement = 0;

    for (int iteration = 0; iteration < maxIterations; iteration++) {
      List<List<Integer>> bestNeighbor = null;
      int bestMakespan = Integer.MAX_VALUE;

      for (List<List<Integer>> neighbor : generator.getNeighbors(currentSchedule)) {
        
        int neighborMakespan = fitnessFunction.calculateMakespan(neighbor);
        if (neighborMakespan < bestMakespan) {
          bestMakespan = neighborMakespan;
          bestNeighbor = neighbor;
        }
      }
      if (bestMakespan < currentMakespan) {
        currentSchedule = bestNeighbor;
        currentMakespan = bestMakespan;
        iterationsWithoutImprovement = 0;
      } else {
        iterationsWithoutImprovement++;
      }

      if (iterationsWithoutImprovement >= restartThreshold) {
        currentSchedule = generator.generateSchedule(jobs, numMachines);
        currentMakespan = fitnessFunction.calculateMakespan(currentSchedule);
        iterationsWithoutImprovement = 0;
      }
    }

    return currentSchedule;
    // throw new UnsupportedOperationException("Implement me");
  }
}
