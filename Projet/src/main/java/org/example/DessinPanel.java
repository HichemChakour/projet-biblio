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

    public void effacerToutesFigures() {
        lignes.clear();
        cercles.clear();
        triangles.clear();
        quadrilateres.clear();
        repaint(); // Redessine le panel pour le vider
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        int largeur = getWidth();
        int hauteur = getHeight();

        // Centrer l'origine (0,0) au milieu de la fenêtre
        g2.translate(largeur / 2, hauteur / 2);

        int pas = 50; // Espacement des graduations

        // Dessiner les axes
        g2.setColor(Color.LIGHT_GRAY);
        g2.drawLine(-largeur / 2, 0, largeur / 2, 0); // Axe horizontal
        g2.drawLine(0, -hauteur / 2, 0, hauteur / 2); // Axe vertical

        // Dessiner les graduations
        for (int x = -largeur / 2; x <= largeur / 2; x += pas) {
            g2.drawLine(x, -5, x, 5);
            g2.drawString(String.valueOf(x), x + 2, 15);
        }
        for (int y = -hauteur / 2; y <= hauteur / 2; y += pas) {
            g2.drawLine(-5, y, 5, y);
            if (y != 0) g2.drawString(String.valueOf(-y), 8, y + 5);
        }

        g2.setColor(Color.BLACK); // Revenir à la couleur par défaut pour les figures

        // Ajuster les coordonnées des figures par rapport au nouveau repère centré
        for (Ligne ligne : lignes) {
            g2.drawLine(
                    (int) ligne.start.getX(), (int) -ligne.start.getY(),
                    (int) ligne.end.getX(), (int) -ligne.end.getY()
            );
        }

        for (Cercle cercle : cercles) {
            int x = (int) (cercle.getCentre().getX() - cercle.getRayon());
            int y = (int) -(cercle.getCentre().getY() + cercle.getRayon());
            g2.drawOval(x, y, (int) (cercle.getRayon() * 2), (int) (cercle.getRayon() * 2));
        }

        for (Triangle triangle : triangles) {
            g2.drawLine(
                    (int) triangle.getP1().getX(), (int) -triangle.getP1().getY(),
                    (int) triangle.getP2().getX(), (int) -triangle.getP2().getY()
            );
            g2.drawLine(
                    (int) triangle.getP2().getX(), (int) -triangle.getP2().getY(),
                    (int) triangle.getP3().getX(), (int) -triangle.getP3().getY()
            );
            g2.drawLine(
                    (int) triangle.getP3().getX(), (int) -triangle.getP3().getY(),
                    (int) triangle.getP1().getX(), (int) -triangle.getP1().getY()
            );
        }

        for (Quadrilatere quadrilatere : quadrilateres) {
            g2.drawLine(
                    (int) quadrilatere.getP1().getX(), (int) -quadrilatere.getP1().getY(),
                    (int) quadrilatere.getP2().getX(), (int) -quadrilatere.getP2().getY()
            );
            g2.drawLine(
                    (int) quadrilatere.getP2().getX(), (int) -quadrilatere.getP2().getY(),
                    (int) quadrilatere.getP3().getX(), (int) -quadrilatere.getP3().getY()
            );
            g2.drawLine(
                    (int) quadrilatere.getP3().getX(), (int) -quadrilatere.getP3().getY(),
                    (int) quadrilatere.getP4().getX(), (int) -quadrilatere.getP4().getY()
            );
            g2.drawLine(
                    (int) quadrilatere.getP4().getX(), (int) -quadrilatere.getP4().getY(),
                    (int) quadrilatere.getP1().getX(), (int) -quadrilatere.getP1().getY()
            );
        }
    }
}
