package ru.vsu.cs;

public class Circle {
    double x0;
    double y0;
    double radius;

    public Circle(double x0, double y0, double radius) {
        this.x0 = x0;
        this.y0 = y0;
        this.radius = radius;
    }

    public boolean isPointInside(double x, double y) {
        double dx = x - x0;
        double dy = y - y0;
        double distance = Math.sqrt(dx * dx + dy * dy);
        return (distance <= radius);
    }
}