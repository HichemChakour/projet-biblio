package org.example;

public class Rectangle {

    // Variables pour les côtés
    private double longueur;
    private double largeur;

    // Constructeur
    public Rectangle(double longueur, double largeur) {
        this.longueur = longueur;
        this.largeur = largeur;
    }

    // Méthode pour calculer l'aire
    public double getAire() {
        return longueur * largeur;
    }

    // Méthode pour calculer le périmètre
    public double getPerimetre() {
        return 2 * (longueur + largeur);
    }
}
