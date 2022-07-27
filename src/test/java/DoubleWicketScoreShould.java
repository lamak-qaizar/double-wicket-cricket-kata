import delivery.Delivery;
import org.junit.Test;

public class DoubleWicketScoreShould {

    @Test
    public void scoreRunsOffASingleDelivery() {
        DoubleWicketScore score = new DoubleWicketScore()
                .add(Delivery.with(5, "normal"));
        assertThatScoreIs(score, 5, 1);
    }

    private void assertThatScoreIs(DoubleWicketScore score, int runs, int deliveries) {
        assert score.getRuns() == runs;
        assert score.getDeliveries() == deliveries;
    }

    @Test
    public void scoreRunsOffAnotherSingleDelivery() {
        DoubleWicketScore score = new DoubleWicketScore()
                .add(Delivery.with(3, "normal"));
        assertThatScoreIs(score, 3, 1);
    }

    @Test
    public void scoreRunsOffMultipleDelivery() {
        DoubleWicketScore score = new DoubleWicketScore()
                .add(Delivery.with(3, "normal"))
                .add(Delivery.with(0, "normal"))
                .add(Delivery.with(5, "normal"));
        assertThatScoreIs(score, 8, 3);
    }

    @Test
    public void scoreAdditionalRunOffAWide() {
        DoubleWicketScore score = new DoubleWicketScore()
                .add(Delivery.with(3, "wide"));
        assertThatScoreIs(score, 4, 0);
    }

    @Test
    public void scoreNoRunsOffABye() {
        DoubleWicketScore score = new DoubleWicketScore()
                .add(Delivery.with(3, "bye"));
        assertThatScoreIs(score, 0, 1);
    }

    @Test
    public void reduceBy5WhenAWicketIsTaken() {
        DoubleWicketScore score = new DoubleWicketScore()
                .add(Delivery.with(2, "out"));
        assertThatScoreIs(score, -5, 1);
    }

    @Test
    public void beAbleToCalculateScoreForAnOver() {
        DoubleWicketScore score = new DoubleWicketScore()
                .add(Delivery.with(2, "out"))
                .add(Delivery.with(3, "normal"))
                .add(Delivery.with(4, "bye"))
                .add(Delivery.with(1, "wide"))
                .add(Delivery.with(6, "normal"))
                .add(Delivery.with(1, "bye"))
                .add(Delivery.with(1, "bye"));
        assertThatScoreIs(score, 6, 6);
    }
}
