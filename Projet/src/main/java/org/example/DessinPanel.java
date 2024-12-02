package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DessinPanel extends JPanel {
    private final List<Ligne> lignes;
    private final List<Cercle> cercles;
    private final List<Quadrilatere> quadrilateres;
    private final List<Triangle> triangles;
    public DessinPanel() {
        this.lignes = new ArrayList<>();
        this.cercles = new ArrayList<>();
        this.quadrilateres = new ArrayList<>();
        this.triangles = new ArrayList<>();
    }

    public void ajouterLigne(Ligne ligne) {
        lignes.add(ligne);
        repaint(); // Redessine le panel
    }

    public void ajouterCercle(Cercle cercle) {
        cercles.add(cercle);
        repaint(); // Redessine le panel
    }

    public void ajouterTriangle(Triangle triangle) {
        triangles.add(triangle);
        repaint(); // Redessine le panel
    }
    public void ajouterQuadrilatere(Quadrilatere quadrilatere) {
        quadrilateres.add(quadrilatere);
        repaint(); // Redessine le panel
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dessiner les lignes
        for (Ligne ligne : lignes) {
            g.drawLine((int) ligne.start.getX(), (int) ligne.start.getY(), (int) ligne.end.getX(), (int) ligne.end.getY());
        }
        // Dessiner les cercles
        for (Cercle cercle : cercles) {
            int x = (int) (cercle.getCentre().getX() - cercle.getRayon());
            int y = (int) (cercle.getCentre().getY() - cercle.getRayon());
            g.drawOval(x, y, (int) (cercle.getRayon() * 2), (int) (cercle.getRayon() * 2));
        }
        for (Quadrilatere quadrilatere : quadrilateres) {
            g.drawLine((int) quadrilatere.getP1().getX(), (int) quadrilatere.getP1().getY(), (int) quadrilatere.getP2().getX(), (int) quadrilatere.getP2().getY());
            g.drawLine((int) quadrilatere.getP2().getX(), (int) quadrilatere.getP2().getY(), (int) quadrilatere.getP3().getX(), (int) quadrilatere.getP3().getY());
            g.drawLine((int) quadrilatere.getP3().getX(), (int) quadrilatere.getP3().getY(), (int) quadrilatere.getP4().getX(), (int) quadrilatere.getP4().getY());
            g.drawLine((int) quadrilatere.getP4().getX(), (int) quadrilatere.getP4().getY(), (int) quadrilatere.getP1().getX(), (int) quadrilatere.getP1().getY());
        }
        for (Triangle triangle : triangles) {
            g.drawLine((int) triangle.getP1().getX(), (int) triangle.getP1().getY(), (int) triangle.getP2().getX(), (int) triangle.getP2().getY());
            g.drawLine((int) triangle.getP2().getX(), (int) triangle.getP2().getY(), (int) triangle.getP3().getX(), (int) triangle.getP3().getY());
            g.drawLine((int) triangle.getP3().getX(), (int) triangle.getP3().getY(), (int) triangle.getP1().getX(), (int) triangle.getP1().getY());
        }
    }
}
