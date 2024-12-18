package org.example;

import static org.example.Arrondi.arrondi;

public class Cercle implements ICalculMethods{
    private final double rayon;
    private final Point centre;
    public static double pi =3.141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117067982148086513282306647093844609550582231725359408128481;

    public Cercle(Point centre, Point point) {
        this.centre = centre;
        this.rayon = centre.distance(point);

    }

    public double getRayon() {
        return rayon;
    }
    @Override
    public double getPerimetre() {
        return 2 * pi * rayon;
    }

    @Override
    public double getPerimetre(int arrondi) {
        double perimetre = this.getPerimetre();
            return arrondi(perimetre, arrondi);

    }
    public Point getCentre() {
        return centre;
    }
    @Override
    public double getAire() {
        return pi * rayon * rayon;
    }

    @Override
    public double getAire(int arrondi) {
        double aire = this.getAire();
            return arrondi(aire, arrondi);
    }

    @Override
    public boolean estInterieur(Point point) {
        double distance = centre.distance(point); // Calcul de la distance entre le point et le centre
        return distance <= rayon; // Vrai si la distance est inférieure ou égale au rayon
    }

    public void translate(double dx, double dy) {
        centre.setX(centre.getX() + dx);
        centre.setY(centre.getY() + dy);
    }
    public void rotate(Point center, double angle) {
    double radians = Math.toRadians(angle);
    double dx = centre.getX() - center.getX();
    double dy = centre.getY() - center.getY();
    double newX = center.getX() + dx * Math.cos(radians) - dy * Math.sin(radians);
    double newY = center.getY() + dx * Math.sin(radians) + dy * Math.cos(radians);
    centre.setX(newX);
    centre.setY(newY);
}
}
