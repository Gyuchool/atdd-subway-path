package wooteco.subway.domain;

public class PathAdapter {
    private final PathFinder pathFinder;

    public PathAdapter(final PathFinder pathFinder) {
        this.pathFinder = pathFinder;
    }

    public Path getShortestPath(final Station source, final Station target) {
        return pathFinder.getPath(source, target);
    }

    public Long getExpensiveLineId(final Station source, final Station target) {
        return pathFinder.getExpensiveLineId(source, target);
    }
}
