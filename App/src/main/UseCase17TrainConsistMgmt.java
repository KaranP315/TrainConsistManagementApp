import java.util.Arrays;

public class UseCase17TrainConsistMgmt {

    public static void main(String[] args) {

        System.out.println("=== UC17: Arrays.sort() ===");

        // Step 1: Array of bogie names
        String[] bogies = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        // Step 2: Sort using built-in method
        Arrays.sort(bogies);

        // Step 3: Display sorted array
        System.out.println("Sorted Bogie Names:");
        System.out.println(Arrays.toString(bogies));
    }
}