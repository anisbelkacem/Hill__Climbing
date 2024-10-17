package de.uni_passau.fim.se2.se.hillclimbing;

import java.util.List;

/**
 * Generates random schedules for the hill climbing algorithm.
 */
public class ScheduleGenerator {

    /**
     * Generates a random schedule for the given jobs and number of machines.
     *
     * @param jobs        the jobs to schedule
     * @param numMachines the number of machines
     * @return a random schedule
     */
    public List<List<Integer>> generateSchedule(int[] jobs, int numMachines) {
        throw new UnsupportedOperationException("Implement me");
    }

    /**
     * Generate all neighbors of the current schedule by moving a single from one machine to another.
     *
     * @param schedule the current schedule
     * @return a list of all neighbors of the current schedule
     */
    public List<List<List<Integer>>> getNeighbors(List<List<Integer>> schedule) {
        throw new UnsupportedOperationException("Implement me");
    }
}
