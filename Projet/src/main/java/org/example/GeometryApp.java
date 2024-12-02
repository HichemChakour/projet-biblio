package org.example;
import javax.swing.*;
import java.awt.*;

public class GeometryApp extends JFrame{
    private final DessinPanel dessinPanel;

    public GeometryApp() {
        setTitle("Plan 2D Géométrique");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dessinPanel = new DessinPanel();
        add(dessinPanel, BorderLayout.CENTER);

        // Exemple : Ajouter quelques objets
        Ligne ligne = new Ligne(new Point(100, 100), new Point(200, 200));
        Cercle cercle = new Cercle(new Point(300, 300), new Point(400, 400));
        Triangle triangle = new Triangle(new Point(200, 200), new Point(400, 200), new Point(300, 300));
        Quadrilatere quadrilatere = new Quadrilatere(new Point(200, 100), new Point(400, 100), new Point(400, 200), new Point(200, 200));
        dessinPanel.ajouterTriangle(triangle);
        dessinPanel.ajouterQuadrilatere(quadrilatere);
        dessinPanel.ajouterLigne(ligne);
        dessinPanel.ajouterCercle(cercle);
    }
}
