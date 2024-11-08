package org.example;

public class Main {
    public static void main(String[] args) {
        //Test des diverses classes
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 1);
        Point p3 = new Point(1, 0);
        Point p4 = new Point(1, 4);

        System.out.println("TEST DE LA CLASSE : Triangle");

        Triangle t = new Triangle(p1, p2, p3);
        System.out.println(t.surface());
        System.out.println(t.getPerimetre());
        System.out.println("TEST DE LA CLASSE : RECTANGLE");
        System.out.println("Rectangle en 3 points :");
        Rectangle r3Points = new Rectangle(p1, p2, p3);
        System.out.println(r3Points.getAire());
        System.out.println("Rectangle en 4 points");
        Rectangle r4Points = new Rectangle(p1, p2, p3, p4);
        System.out.println(r4Points.getAire());

        System.out.println("TEST DE LA CLASSE : Cercle");
        Cercle c = new Cercle(p1, p4);
        System.out.println("l'aire est de "+c.getAire(100)+". Le périmètre est de :"+c.getPerimetre());


    }

}