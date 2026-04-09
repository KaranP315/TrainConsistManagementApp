import java.util.ArrayList;

public class TrainConsistApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // Step 1: Create ArrayList
        ArrayList<String> passengerBogies = new ArrayList<>();

        // Step 2: Add bogies
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        // Step 3: Display bogies
        System.out.println("\nPassenger Bogies after addition:");
        System.out.println(passengerBogies);

        // Step 4: Remove a bogie (AC Chair)
        passengerBogies.remove("AC Chair");

        System.out.println("\nAfter removing AC Chair:");
        System.out.println(passengerBogies);

        // Step 5: Check if Sleeper exists
        if (passengerBogies.contains("Sleeper")) {
            System.out.println("\nSleeper bogie exists in the train.");
        } else {
            System.out.println("\nSleeper bogie NOT found.");
        }

        // Step 6: Final list
        System.out.println("\nFinal Passenger Bogies:");
        System.out.println(passengerBogies);
    }
}