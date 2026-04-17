import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * UC13: Performance Comparison Test
 * Note: This assumes Bogie and PassengerBogie are defined in your main file.
 * If you get "Duplicate Class", it means they are already defined elsewhere in the folder.
 */
public class TrainConsistPerformanceTest {
    private List<Bogie> testConsist;

    @BeforeEach
    void setUp() {
        testConsist = new ArrayList<>();
        // Adding sample data
        testConsist.add(new PassengerBogie("P1", 70));
        testConsist.add(new PassengerBogie("P2", 40));
        testConsist.add(new PassengerBogie("P3", 85));
        testConsist.add(new PassengerBogie("P4", 10));
    }

    @Test
    void testLoopFilteringLogic() {
        List<Bogie> filtered = new ArrayList<>();
        for (Bogie b : testConsist) {
            if (b.getCapacity() > 60) {
                filtered.add(b);
            }
        }
        assertEquals(2, filtered.size(), "Loop should find exactly 2 bogies with capacity > 60");
    }

    @Test
    void testStreamFilteringLogic() {
        List<Bogie> filtered = testConsist.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
        assertEquals(2, filtered.size(), "Stream should find exactly 2 bogies with capacity > 60");
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : testConsist) {
            if (b.getCapacity() > 60) loopResult.add(b);
        }

        List<Bogie> streamResult = testConsist.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        assertEquals(loopResult.size(), streamResult.size(), "Both methods must return the same number of results");
    }

    @Test
    void testExecutionTimeMeasurement() {
        long start = System.nanoTime();
        // Simple operation to ensure time elapses
        testConsist.stream().filter(b -> b.getCapacity() > 0).count();
        long end = System.nanoTime();

        long elapsed = end - start;
        assertTrue(elapsed > 0, "Execution time measured in nanoseconds should be greater than zero");
    }

    @Test
    void testLargeDatasetProcessing() {
        List<Bogie> largeConsist = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            largeConsist.add(new PassengerBogie("T" + i, 100));
        }

        long count = largeConsist.stream().filter(b -> b.getCapacity() > 60).count();
        assertEquals(10000, count, "Should process large dataset correctly");
    }
}