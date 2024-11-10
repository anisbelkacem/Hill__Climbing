package de.uni_passau.fim.se2.se.hillclimbing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class HillClimbingTest {

    @Test
    void testOptimize1() {
        ScheduleGenerator generator = new ScheduleGenerator();
        FitnessFunction fitnessGenerator = new FitnessFunction();

        HillClimbing hillClimbing = new HillClimbing(generator, fitnessGenerator);
        int[] jobs = {1, 2, 3, 4};

        List<List<Integer>> result = hillClimbing.optimize(jobs, 2, 100, 100);
        int expected = 5;
        assertEquals(expected, fitnessGenerator.calculateMakespan(result));
    }
    @Test
    void testOptimize2() {
        ScheduleGenerator generator = new ScheduleGenerator();
        FitnessFunction fitnessGenerator = new FitnessFunction();

        HillClimbing hillClimbing = new HillClimbing(generator, fitnessGenerator);
        int[] jobs = {1};

        List<List<Integer>> result = hillClimbing.optimize(jobs, 2, 100, 100);
        int expected = 1;
        assertEquals(expected, fitnessGenerator.calculateMakespan(result));
    }
    @Test
    void testOptimize3() {
        ScheduleGenerator generator = new ScheduleGenerator();
        FitnessFunction fitnessGenerator = new FitnessFunction();

        HillClimbing hillClimbing = new HillClimbing(generator, fitnessGenerator);
        int[] jobs = {1,100,2,3};

        List<List<Integer>> result = hillClimbing.optimize(jobs, 2, 100, 100);
        int expected = 100;
        assertEquals(expected, fitnessGenerator.calculateMakespan(result));
    }
    @Test
    void testOptimize4() {
        ScheduleGenerator generator = new ScheduleGenerator();
        FitnessFunction fitnessGenerator = new FitnessFunction();

        HillClimbing hillClimbing = new HillClimbing(generator, fitnessGenerator);
        int[] jobs = {1,0,1};

        List<List<Integer>> result = hillClimbing.optimize(jobs, 2, 100, 100);
        int expected = 1;
        assertEquals(expected, fitnessGenerator.calculateMakespan(result));
    }
}
