package org.example;

public class Triangle implements ICalculMethods{
    private Point p1;
    private Point p2;
    private Point p3;

    public Triangle(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    @Override
    public double getAire() {
        double base = p1.distance(p2);
        double hauteur = Math.abs((p2.getY() - p1.getY()) * p3.getX() - (p2.getX() - p1.getX()) * p3.getY() + p2.getX() * p1.getY() - p2.getY() * p1.getX()) /
                Math.sqrt(Math.pow(p2.getY() - p1.getY(), 2) + Math.pow(p2.getX() - p1.getX(), 2));
        return (base * hauteur) / 2;
    }

    @Override
    public double getAire(int arrondi) {
        double aire = this.getAire();
            return Arrondi.arrondi(aire, arrondi);
    }


    @Override
    public double getPerimetre() {
        return p1.distance(p2) + p2.distance(p3) + p3.distance(p1);
    }

    @Override
    public double getPerimetre(int arrondi) {
        double perimetre =this.getPerimetre();
            return Arrondi.arrondi(perimetre, arrondi);

    }

    @Override
    public boolean estInterieur(Point point) {
        double aire1 = new Triangle(p1, p2, point).getAire();
        double aire2 = new Triangle(p2, p3, point).getAire();
        double aire3 = new Triangle(p3, p1, point).getAire();

        double aireTotal = aire1 + aire2 + aire3;
        return Math.abs(aireTotal - this.getAire()) < 1e-9;
    }
}
