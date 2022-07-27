package delivery;

public class Delivery {
    private final int runs;

    Delivery(int runs) {
        this.runs = runs;
    }

    public static Delivery with(int runs, String type) {
        if (type == "wide") {
            return new Wide(runs);
        } else if (type == "bye") {
            return new Bye();
        } else if (type == "out") {
            return new Out();
        }
        return new Delivery(runs);
    }

    public int runs() {
        return runs;
    }

    public int incrementDeliveriesBy() {
        return 1;
    }
}