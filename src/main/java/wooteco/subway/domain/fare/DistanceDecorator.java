package wooteco.subway.domain.fare;

public class DistanceDecorator extends Decorator {
    private final int distance;

    public DistanceDecorator(final Fare fare, final int distance) {
        super(fare);
        this.distance = distance;
    }

    @Override
    public double calculateExtraFare() {
        return super.calculateExtraFare() + DistanceExtraFare.valueOf(distance);
    }
}