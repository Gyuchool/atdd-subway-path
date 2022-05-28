package wooteco.subway.domain;

import wooteco.subway.domain.fare.AgeDecorator;
import wooteco.subway.domain.fare.BaseFare;
import wooteco.subway.domain.fare.DistanceDecorator;
import wooteco.subway.domain.fare.Fare;

import java.util.LinkedList;
import java.util.List;

public class Path {
    private final List<Station> stations;
    private final int distance;

    public Path(final List<Station> stations, final int distance) {
        this.stations = new LinkedList<>(stations);
        this.distance = distance;
    }

    public double calculateFare( final int extraFare, final int age){
        Fare fare = new AgeDecorator(new DistanceDecorator(new BaseFare(extraFare), distance), age);
        return fare.calculateExtraFare();
    }
    public List<Station> getStations() {
        return new LinkedList<>(stations);
    }

    public int getDistance() {
        return distance;
    }

}
