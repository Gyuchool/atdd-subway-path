package wooteco.subway.domain;

public interface PathFinder {
    Path getPath(final Station source, final Station target);

    Long getExpensiveLineId(Station source, Station target);
}
