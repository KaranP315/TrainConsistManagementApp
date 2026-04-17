public class UseCase15TrainConsistMgmt {

    public static void main(String[] args) {

        System.out.println("=== UC15: Cargo Safety Handling ===");

        GoodsBogie b1 = new GoodsBogie("Cylindrical");
        b1.assignCargo("Petroleum"); // valid

        GoodsBogie b2 = new GoodsBogie("Rectangular");
        b2.assignCargo("Petroleum"); // invalid

        System.out.println("Program continues safely...");
    }
}