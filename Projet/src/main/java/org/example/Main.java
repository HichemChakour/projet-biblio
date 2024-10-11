package org.example;

public class Main {
    public static void main(String[] args) {
        //Test des diverses classes
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 2);
        Point p3 = new Point(2, 2);
        Point p4 = new Point(2, 0);

        System.out.println("TEST DE LA CLASSE : Triangle");
        Triangle t = new Triangle(p1, p2, p3);
        System.out.println("l'aire est de "+t.getAire()+". Le périmètre est de :"+t.getPerimetre());

        System.out.println("TEST DE LA CLASSE : Quadrilatere");
        Quadrilatere r4Points = new Quadrilatere(p1, p2, p3, p4);
        System.out.println("l'aire est de "+r4Points.getAire()+". Le périmètre est de :"+r4Points.getPerimetre());

        System.out.println("TEST DE LA CLASSE : Cercle");
        Cercle c = new Cercle(p1, p4);
        System.out.println("l'aire est de "+c.getAire(100)+". Le périmètre est de :"+c.getPerimetre());
    }
}