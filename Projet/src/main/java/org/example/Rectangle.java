package org.example;

public class Rectangle {

    // Variables pour les côtés
    private Point p1;
    private Point p2;

    // Constructeur
    public Rectangle(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public double longueur(){
        return Math.abs(p2.getY() - p1.getY());
    }
    public double largeur(){
        return Math.abs(p2.getX() - p1.getX());
    }

    // Méthode pour calculer l'aire
    public double getAire() {
        return longueur() * largeur();
    }

    // Méthode pour calculer le périmètre
    public double getPerimetre() {
        return 2 * (longueur() + largeur());
    }
}
