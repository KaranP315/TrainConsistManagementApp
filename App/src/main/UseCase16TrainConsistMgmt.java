public class UseCase16TrainConsistMgmt {

    public static void main(String[] args) {

        System.out.println("=== UC16: Bubble Sort ===");

        // Step 1: Array of capacities
        int[] capacities = {72, 56, 24, 70, 60};

        // Step 2: Bubble Sort
        int n = capacities.length;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (capacities[j] > capacities[j + 1]) {

                    // Swap
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                }
            }
        }

        // Step 3: Display sorted array
        System.out.println("Sorted Capacities:");

        for (int c : capacities) {
            System.out.print(c + " ");
        }
    }
}