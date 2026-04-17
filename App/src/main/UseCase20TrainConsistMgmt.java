import java.util.Scanner;

public class UseCase20TrainConsistMgmt {

    public static void main(String[] args) {

        System.out.println("=== UC20: Search Exception Handling ===");

        // Step 1: Empty bogie array (simulate no data)
        String[] bogieIds = {};

        // Step 2: Fail-fast check
        if (bogieIds.length == 0) {
            throw new IllegalStateException("No bogies available for search!");
        }

        // Step 3: Search input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Bogie ID to search: ");
        String key = sc.nextLine();

        // Step 4: Linear search
        boolean found = false;

        for (String id : bogieIds) {
            if (id.equals(key)) {
                found = true;
                break;
            }
        }

        // Step 5: Output result
        if (found) {
            System.out.println("Bogie ID found.");
        } else {
            System.out.println("Bogie ID not found.");
        }

        sc.close();
    }
}