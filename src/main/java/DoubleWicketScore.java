import delivery.Delivery;

public class DoubleWicketScore {
    private final int runs;
    private final int deliveriesBowled;

    public DoubleWicketScore(int runs, int deliveriesBowled) {
        this.runs = runs;
        this.deliveriesBowled = deliveriesBowled;
    }

    public DoubleWicketScore() {
        deliveriesBowled = 0;
        runs = 0;
    }

    public DoubleWicketScore add(Delivery delivery) {
        return new DoubleWicketScore(this.runs + delivery.runs(), this.deliveriesBowled + delivery.incrementDeliveriesBy());
    }

    public int getRuns() {
        return this.runs;
    }

    public int getDeliveries() {
        return deliveriesBowled;
    }
}
