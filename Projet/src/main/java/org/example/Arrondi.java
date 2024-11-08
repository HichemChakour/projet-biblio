package org.example;

public abstract class Arrondi {
    public static double arrondi(double valeur, int arrondi) {
        if (arrondi == 0) {
            return valeur;
        } else {
            return (double) Math.round(valeur * arrondi) / arrondi;
        }
    }
}
