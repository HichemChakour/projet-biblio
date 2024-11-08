package org.example;

import static org.example.Arrondi.arrondi;

public class Cercle implements ICalculMethods{
    private double rayon;

    private static double pi =3.141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117067982148086513282306647093844609550582231725359408128481;

    Cercle(Point centre, Point point) {
        this.rayon = centre.distance(point);

    }

    double getRayon() {
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

    @Override
    public double getAire() {
        return pi * rayon * rayon;
    }

    @Override
    public double getAire(int arrondi) {
        double aire = this.getAire();
            return arrondi(aire, arrondi);
    }
}
