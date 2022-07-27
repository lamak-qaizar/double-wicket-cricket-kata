package delivery;

public class Wide extends Delivery {

    public Wide(int runs) {
        super(runs);
    }

    @Override
    public int runs() {
        return super.runs() + 1;
    }

    @Override
    public int incrementDeliveriesBy() {
        return 0;
    }
}
