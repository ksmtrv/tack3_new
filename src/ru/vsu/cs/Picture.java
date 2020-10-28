package ru.vsu.cs;

public class Picture {
    private final Circle circle;
    private final VerticalParabola verticalParabola;
    private final HorizontalParabola horizontalParabola1;
    private final HorizontalParabola horizontalParabola2;

    public Picture(Circle circle, VerticalParabola verticalParabola, HorizontalParabola horisontalParabola1, HorizontalParabola horisontalParabola2) {
        this.circle = circle;
        this.verticalParabola = verticalParabola;
        this.horizontalParabola1 = horisontalParabola1;
        this.horizontalParabola2 = horisontalParabola2;
    }

    public SimpleColor getColor(Point point) {
        double x = point.getX();
        double y = point.getY();

        if (circle.isPointInside(x, y) && horizontalParabola1.isPointInside(x, y) && x > 3) return SimpleColor.YELLOW;

        if (circle.isPointInside(x, y) && !horizontalParabola2.isPointInside(x, y) && x < 0) return SimpleColor.GREEN;

        if (circle.isPointInside(x, y)) return SimpleColor.WHITE;

        if (horizontalParabola1.isPointInside(x, y)) return SimpleColor.BLUE;

        if (!horizontalParabola2.isPointInside(x, y)) return SimpleColor.ORANGE;

        if (verticalParabola.isPointInside(x, y)) return SimpleColor.BLUE;

        if (x > 1 && y < -2) return SimpleColor.BLUE;

        if (x < 1 && y < 2) return SimpleColor.GREEN;

        return SimpleColor.ORANGE;
    }
}