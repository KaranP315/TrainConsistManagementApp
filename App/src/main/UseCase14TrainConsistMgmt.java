public class UseCase14TrainConsistMgmt {

    public static void main(String[] args) {

        System.out.println("=== UC14: Custom Exception Demo ===");

        try {
            PassengerBogie b1 = new PassengerBogie("Sleeper", 72);
            System.out.println("Created: " + b1);

            PassengerBogie b2 = new PassengerBogie("AC Chair", -10); // Invalid
            System.out.println("Created: " + b2);

        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}