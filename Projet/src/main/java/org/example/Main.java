package org.example;
import javax.swing.*;
public class Main {
    public static void main(String[] args)  {
        /*Test des diverses classes
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 2);
        Point p3 = new Point(2, 2);
        Point p4 = new Point(2, 0);
        Point pointInterieur = new Point(1, 1); // Point à tester à l'intérieur
        Point pointExterieur = new Point(3, 3); // Point à tester à l'extérieur

        System.out.println("TEST DE LA CLASSE : Triangle");
        Triangle t = new Triangle(p1, p2, p3);
        System.out.println("l'aire est de "+t.getAire()+". Le périmètre est de :"+t.getPerimetre());
        System.out.println("Point " + pointInterieur + " à l'intérieur du triangle ? " + t.estInterieur(pointInterieur));
        System.out.println("Point " + pointExterieur + " à l'intérieur du triangle ? " + t.estInterieur(pointExterieur));


        System.out.println("TEST DE LA CLASSE : Quadrilatere");
        Quadrilatere r4Points = new Quadrilatere(p1, p2, p3, p4);
        System.out.println("l'aire est de "+r4Points.getAire()+". Le périmètre est de :"+r4Points.getPerimetre());
        System.out.println("Point " + pointInterieur + " à l'intérieur du quadrilatère ? " + r4Points.estInterieur(pointInterieur));
        System.out.println("Point " + pointExterieur + " à l'intérieur du quadrilatère ? " + r4Points.estInterieur(pointExterieur));

        System.out.println("TEST DE LA CLASSE : Cercle");
        Cercle c = new Cercle(p1, p4);
        System.out.println("l'aire est de "+c.getAire(100)+". Le périmètre est de :"+c.getPerimetre());
        System.out.println("Point " + pointInterieur + " à l'intérieur du cercle ? " + c.estInterieur(pointInterieur));
        System.out.println("Point " + pointExterieur + " à l'intérieur du cercle ? " + c.estInterieur(pointExterieur));

        System.out.println("Test de la classe abstraite : arrondi");
        System.out.println("Aire du cercle avant : "+c.getAire()+" après arrondi : "+c.getAire(1));*/
        SwingUtilities.invokeLater(() -> {
            GeometryApp app = new GeometryApp();
            app.setVisible(true);
        });
    }
}