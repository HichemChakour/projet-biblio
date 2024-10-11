package org.example;

public class Cercle {
    private double rayon;

    private static double pi =3.141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117067982148086513282306647093844609550582231725359408128481;

    Cercle(double rayon) {
        this.rayon = rayon;

    }

    double getRayon() {
        return rayon;
    }
    double getPerimetre() {
        return 2 * pi * rayon;
    }

    double getPerimetre(int arrondi) {
        double perimetre = 2 * pi * rayon;
        if (arrondi == 0) {
            return perimetre;
        } else {
            return (double) Math.round(perimetre * arrondi) / arrondi;
        }

    }

    double getAire() {
        return pi * rayon * rayon;
    }

    double getAire(int arrondi) {
        double aire =pi * rayon * rayon;
        if (arrondi == 0) {
            return aire;
        } else {
            return (double) Math.round(aire * arrondi) / arrondi;
        }
    }
}