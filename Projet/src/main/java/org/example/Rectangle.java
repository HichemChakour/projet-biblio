package org.example;

public class Rectangle {

    // Variables pour les côtés
    private Point p1;
    private Point p2;
    private Point p3;
    private Point p4;

    // Constructeur
    public Rectangle(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = calculerPointQuatre(p1, p2, p3);
    }

    public Rectangle(Point p1, Point p2, Point p3, Point p4) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }
    private Point calculerPointQuatre(Point p1, Point p2, Point p3) {
        double x4 = p1.getX() + p3.getX() - p2.getX();
        double y4 = p1.getY() + p3.getY() - p2.getY();
        return new Point(x4, y4);
    }
    public double longueur(){
        return p1.distance(p2);
    }
    public double largeur(){
        return p1.distance(p3);
    }

    // Méthode pour calculer l'aire
    public double getAire() {
        return longueur() * largeur();
    }

    // Méthode pour calculer le périmètre
    public double getPerimetre() {
        return 2 * (longueur() + largeur());
    }
    public Point getP1() {
        return p1;
    }
    public Point getP2() {
        return p2;
    }
    public Point getP3() {
        return p3;
    }
    public Point getP4() {
        return p4;
    }
}
