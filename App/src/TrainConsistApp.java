import java.util.*;

class GoodsBogie {
    String type;   // Cylindrical / Rectangular
    String cargo;  // Petroleum / Coal / etc.

    public GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }
}


public class TrainConsistApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // Step 1: Create goods bogies
        List<GoodsBogie> goods = new ArrayList<>();

        goods.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goods.add(new GoodsBogie("Rectangular", "Coal"));
        goods.add(new GoodsBogie("Cylindrical", "Petroleum"));

        // Step 2: Apply safety validation
        boolean isSafe = goods.stream()
                .allMatch(b ->
                        !b.type.equals("Cylindrical") ||
                                b.cargo.equals("Petroleum")
                );

        // Step 3: Display result
        if (isSafe) {
            System.out.println("\nTrain is SAFE for operation");
        } else {
            System.out.println("\nTrain is NOT SAFE (Invalid cargo detected)");
        }
    }
}