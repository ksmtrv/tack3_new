package ru.vsu.cs;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Picture picture = new Picture(
                new Circle(2, 2, 5),
                new VerticalParabola(1, -3, -0.11111),
                new HorizontalParabola(3, 1, 0.11111),
                new HorizontalParabola(0, 3, -1));

        System.out.println("                         TEST");
        if (testPoints(picture)) {
            start(picture);
        } else {
            System.out.println("The program is not working correctly!");
        }
    }

    private static boolean testPoints(Picture picture) {

        TestCase[] cases = {new TestCase(0, 0, SimpleColor.WHITE),
                new TestCase(4, 1, SimpleColor.YELLOW),
                new TestCase(-2, 3, SimpleColor.GREEN),
                new TestCase(9, 1, SimpleColor.BLUE),
                new TestCase(-6, 3, SimpleColor.ORANGE),
                new TestCase(9, -9, SimpleColor.BLUE),
                new TestCase(-2, -7, SimpleColor.BLUE),
                new TestCase(0, 8, SimpleColor.ORANGE),
                new TestCase(-2, -2, SimpleColor.GREEN)};

        boolean indicator = true;
        for (int i = 0; i < cases.length; i++) {

            TestCase testing = cases[i];
            Point point = new Point(testing.getX(), testing.getY());

            SimpleColor color = picture.getColor(point);
            SimpleColor rightColor = testing.getRightColor();

            boolean check = checkResult(color, rightColor);
            indicator = check && indicator;

            printTest(color, rightColor, point, indicator);
        }
        return indicator;
    }

    private static boolean checkResult(SimpleColor color, SimpleColor rightColor) {
        return color == rightColor;
    }

    private static void start(Picture picture) {
        double x = readDouble("x = ");
        double y = readDouble("y = ");

        Point point = new Point(x, y);
        SimpleColor color = picture.getColor(point);

        printColorForPoint(x, y, color);
    }

    private static double readDouble(String name) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter coordinate %s ", name);
        return scanner.nextDouble();
    }

    private static void printTest(SimpleColor color, SimpleColor rightColor, Point point, boolean indicator) {
        System.out.println("(" + point.getX() + ";" + point.getY() + ") --> " + color +
                ". Right color --> " + rightColor + ". " + indicator);
    }

    private static void printColorForPoint(double x, double y, SimpleColor color) {
        System.out.print("(" + x + ";" + y + ") --> " + color);
    }
}

