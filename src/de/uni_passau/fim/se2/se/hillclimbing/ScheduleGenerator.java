package de.uni_passau.fim.se2.se.hillclimbing;

import java.util.ArrayList;
import java.util.List;

/** Generates random schedules for the hill climbing algorithm. */
public class ScheduleGenerator {

  /**
   * Generates a random schedule for the given jobs and number of machines.
   *
   * @param jobs the jobs to schedule
   * @param numMachines the number of machines
   * @return a random schedule
   */
  public List<List<Integer>> generateSchedule(int[] jobs, int numMachines) {
    if (numMachines == 0) {
        return new ArrayList<>();
      }
    List<List<Integer>> schedule = new ArrayList<>();
    for (int i = 0; i < numMachines; i++) {
      schedule.add(new ArrayList<>());
    }
    for (int i = 0; i < jobs.length; i++) {
      int machine = (int) (Math.random() * numMachines);
      schedule.get(machine).add(jobs[i]);
    }
    return schedule;
    // throw new UnsupportedOperationException("Implement me");
  }

  /**
   * Generate all neighbors of the current schedule by moving a single from one machine to another.
   *
   * @param schedule the current schedule
   * @return a list of all neighbors of the current schedule
   */
  public List<List<List<Integer>>> getNeighbors(List<List<Integer>> schedule) {
    if (schedule.size()==0) {
        return new ArrayList<>();
      }
    List<List<List<Integer>>> neighbors = new ArrayList<>();
    for (int i = 0; i < schedule.size(); i++) {

      for (int j = 0; j < schedule.get(i).size(); j++) {

        int jobToMove = schedule.get(i).get(j);
        for (int k = 0; k < schedule.size(); k++) {
          if (k != i) {
            List<List<Integer>> newSchedule = new ArrayList<>();
            for (int l = 0; l < schedule.size(); l++) {
              newSchedule.add(new ArrayList<>(schedule.get(l)));
            }
            newSchedule.get(i).remove(j);
            newSchedule.get(k).add(jobToMove);
            neighbors.add(newSchedule);
          }
        }
      }
    }
    return neighbors;
  }
}
