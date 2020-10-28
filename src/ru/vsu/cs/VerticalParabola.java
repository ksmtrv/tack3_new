package ru.vsu.cs;

public class VerticalParabola {
    double x0;
    double y0;
    double a;

    public VerticalParabola(double x0, double y0, double a) {
        this.x0 = x0;
        this.y0 = y0;
        this.a = a;
    }

    public boolean isPointInside(double x, double y) {
        return y < a * Math.pow(x - x0, 2) + y0;
    }
}
