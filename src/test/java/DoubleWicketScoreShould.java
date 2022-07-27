import delivery.Delivery;
import org.junit.Test;

public class DoubleWicketScoreShould {

    @Test
    public void scoreRunsOffASingleDelivery() {
        new DoubleWicketScore()
                .add(Delivery.with(5, "normal"))
                .assertThatScoreIs(5, 1);
    }

    @Test
    public void scoreRunsOffAnotherSingleDelivery() {
        new DoubleWicketScore()
                .add(Delivery.with(3, "normal"))
                .assertThatScoreIs(3, 1);
    }

    @Test
    public void scoreRunsOffMultipleDelivery() {
        new DoubleWicketScore()
                .add(Delivery.with(3, "normal"))
                .add(Delivery.with(0, "normal"))
                .add(Delivery.with(5, "normal"))
                .assertThatScoreIs(8, 3);
    }

    @Test
    public void scoreAdditionalRunOffAWide() {
        new DoubleWicketScore()
                .add(Delivery.with(3, "wide"))
                .assertThatScoreIs(4, 0);
    }

    @Test
    public void scoreNoRunsOffABye() {
        new DoubleWicketScore()
                .add(Delivery.with(3, "bye"))
                .assertThatScoreIs(0, 1);
    }

    @Test
    public void reduceBy5WhenAWicketIsTaken() {
        new DoubleWicketScore()
                .add(Delivery.with(2, "out"))
                .assertThatScoreIs(-5, 1);
    }

    @Test
    public void beAbleToCalculateScoreForAnOver() {
        new DoubleWicketScore()
                .add(Delivery.with(2, "out"))
                .add(Delivery.with(3, "normal"))
                .add(Delivery.with(4, "bye"))
                .add(Delivery.with(1, "wide"))
                .add(Delivery.with(6, "normal"))
                .add(Delivery.with(1, "bye"))
                .add(Delivery.with(1, "bye"))
                .assertThatScoreIs(6, 6);
    }
}
