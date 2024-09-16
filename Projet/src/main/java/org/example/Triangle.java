package org.example;

public class Triangle {
    private Point p1;
    private Point p2;
    private Point p3;

    public Triangle(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public double surface() {
        double base = p1.distance(p2);


        double hauteur = Math.abs((p2.getY() - p1.getY()) * p3.getX() - (p2.getX() - p1.getX()) * p3.getY() + p2.getX() * p1.getY() - p2.getY() * p1.getX()) /
                Math.sqrt(Math.pow(p2.getY() - p1.getY(), 2) + Math.pow(p2.getX() - p1.getX(), 2));


        return (base * hauteur) / 2;
    }
}
