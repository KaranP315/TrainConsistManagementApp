import java.util.*;

class Bogie {
    String name;
    int capacity;
    String type;

    public Bogie(String name, int capacity, String type) {
        this.name = name;
        this.capacity = capacity;
        this.type = type;
    }

    public String toString() {
        return name + " (" + capacity + ")";
    }
}


public class TrainConsistApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // Step 1: Create list
        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72, "Passenger"));
        bogies.add(new Bogie("AC Chair", 60, "Passenger"));
        bogies.add(new Bogie("First Class", 24, "Passenger"));

        // Step 2: Stream + map + reduce
        int totalCapacity = bogies.stream()
                .map(b -> b.capacity)         // extract capacity
                .reduce(0, Integer::sum);     // sum all values

        // Step 3: Display result
        System.out.println("\nTotal Seating Capacity: " + totalCapacity);
    }
}
