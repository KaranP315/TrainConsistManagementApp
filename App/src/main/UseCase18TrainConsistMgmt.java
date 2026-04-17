import java.util.Scanner;

public class UseCase18TrainConsistMgmt {

    public static void main(String[] args) {

        System.out.println("=== UC18: Linear Search ===");

        // Step 1: Array of bogie IDs
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        // Step 2: Input search key
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Bogie ID to search: ");
        String key = sc.nextLine();

        // Step 3: Linear Search
        boolean found = false;

        for (String id : bogieIds) {
            if (id.equals(key)) {
                found = true;
                break;
            }
        }

        // Step 4: Output result
        if (found) {
            System.out.println("Bogie ID found in the train.");
        } else {
            System.out.println("Bogie ID not found.");
        }

        sc.close();
    }
}