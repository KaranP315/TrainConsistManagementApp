import java.util.LinkedHashSet;

public class TrainConsistApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // Step 1: Create LinkedHashSet
        LinkedHashSet<String> train = new LinkedHashSet<>();

        // Step 2: Add bogies
        train.add("Engine");
        train.add("Sleeper");
        train.add("Cargo");
        train.add("Guard");

        // Step 3: Add duplicate (will be ignored)
        train.add("Sleeper");

        // Step 4: Display train formation
        System.out.println("\nFinal Train Formation:");
        System.out.println(train);
    }
}