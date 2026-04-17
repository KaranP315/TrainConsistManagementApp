import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// --- Data Model Section ---
abstract class Bogie {
    String id;
    int capacity;

    public Bogie(String id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public int getCapacity() { return capacity; }
}

class PassengerBogie extends Bogie {
    public PassengerBogie(String id, int capacity) {
        super(id, capacity);
    }
}

// --- Main Application Section ---
// Only ONE public class per file, and it must match the filename.
public class PerformanceBenchmarkingApp {

    public static void main(String[] args) {
        // 1. Prepare a collection of bogies (Large dataset for measurement)
        List<Bogie> trainConsist = new ArrayList<>();
        int bogieCount = 100000;
        for (int i = 0; i < bogieCount; i++) {
            trainConsist.add(new PassengerBogie("BOGIE-" + i, (int) (Math.random() * 100)));
        }

        System.out.println("=== UC13: Performance Comparison (Loops vs Streams) ===");
        System.out.println("Processing " + bogieCount + " bogies...\n");

        // 2. Loop-Based Filtering Benchmark
        long startLoop = System.nanoTime();
        List<Bogie> loopFiltered = new ArrayList<>();
        for (Bogie b : trainConsist) {
            if (b.getCapacity() > 60) {
                loopFiltered.add(b);
            }
        }
        long endLoop = System.nanoTime();
        long durationLoop = endLoop - startLoop;

        // 3. Stream-Based Filtering Benchmark
        long startStream = System.nanoTime();
        List<Bogie> streamFiltered = trainConsist.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
        long endStream = System.nanoTime();
        long durationStream = endStream - startStream;

        // 4. Output Performance Results
        System.out.println("Loop-Based Results:");
        System.out.println("- Execution Time: " + durationLoop + " ns");
        System.out.println("- Bogies Found:   " + loopFiltered.size());

        System.out.println("\nStream-Based Results:");
        System.out.println("- Execution Time: " + durationStream + " ns");
        System.out.println("- Bogies Found:   " + streamFiltered.size());

        // 5. Result Consistency Check
        if (loopFiltered.size() == streamFiltered.size()) {
            System.out.println("\n✅ Logic Check: Both methods produced identical result counts.");
        } else {
            System.out.println("\n❌ Logic Check: Result mismatch detected!");
        }

        // 6. Conclusion
        System.out.println("----------------------------------------------");
        if (durationLoop < durationStream) {
            System.out.println("Winner: Traditional Loop (faster by " + (durationStream - durationLoop) + " ns)");
        } else {
            System.out.println("Winner: Stream API (faster by " + (durationLoop - durationStream) + " ns)");
        }
    }
}