package org.example;

public class Quadrilatere {

    // Variables pour les côtés
    private Point p1;
    private Point p2;
    private Point p3;
    private Point p4;

    public Quadrilatere(Point p1, Point p2, Point p3, Point p4) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
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
