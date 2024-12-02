package org.example;

import static org.example.Arrondi.arrondi;

public class Quadrilatere implements ICalculMethods{

    // Variables pour les côtés
    private final Point p1;
    private final Point p2;
    private final Point p3;
    private final Point p4;

    public Quadrilatere(Point p1, Point p2, Point p3, Point p4) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }
    // Méthode pour calculer la longueur des côtés
    private double longueurCote(Point p1, Point p2) {
        return p1.distance(p2);
    }

    // Méthode pour calculer l'aire
    @Override
    public double getAire() {
        // Utilisation de la formule basée sur les coordonnées des sommets
        return 0.5 * Math.abs(
                p1.getX() * p2.getY() + p2.getX() * p3.getY() + p3.getX() * p4.getY() + p4.getX() * p1.getY() -
                        (p2.getX() * p1.getY() + p3.getX() * p2.getY() + p4.getX() * p3.getY() + p1.getX() * p4.getY())
        );
    }

    @Override
    public double getAire(int arrondi) {
        double aire = this.getAire();
            return arrondi(aire, arrondi);

    }

    // Méthode pour calculer le périmètre
    @Override
    public double getPerimetre() {
        // Périmètre = somme des longueurs des côtés
        return longueurCote(p1, p2) + longueurCote(p2, p3) + longueurCote(p3, p4) + longueurCote(p4, p1);
    }

    @Override
    public double getPerimetre(int arrondi) {
        double perimetre = this.getPerimetre();
            return arrondi(perimetre, arrondi);

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
