package org.example;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GeometryApp extends JFrame {
    private final DessinPanel dessinPanel;
    private final JPanel menuPanel;
    private final JComboBox<String> figureSelection;
    private final List<JLabel> pointLabels; // Liste des labels dynamiques
    private final List<JTextField> pointFields; // Liste des champs dynamiques
    private final JTextField radiusField; // Champ pour le rayon

    public GeometryApp() {
        setTitle("Plan 2D Géométrique");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panneau de dessin
        dessinPanel = new DessinPanel();
        add(dessinPanel, BorderLayout.CENTER);

        // Panneau de menu avec bordure
        menuPanel = new JPanel();
        menuPanel.setLayout(new GridBagLayout());
        menuPanel.setBorder(new TitledBorder("Options de Dessin"));
        add(menuPanel, BorderLayout.WEST);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Menu déroulant pour choisir la figure
        gbc.gridx = 0;
        gbc.gridy = 0;
        menuPanel.add(new JLabel("Choisissez une figure :"), gbc);

        figureSelection = new JComboBox<>(new String[]{"Cercle", "Triangle", "Quadrilatere"});
        gbc.gridx = 1;
        menuPanel.add(figureSelection, gbc);

        // Initialiser les champs et labels dynamiques
        pointLabels = new ArrayList<>();
        pointFields = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            pointLabels.add(new JLabel());
            pointFields.add(new JTextField(5));
        }

        // Champ pour le rayon
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        menuPanel.add(new JLabel("Rayon :"), gbc);

        gbc.gridy++;
        radiusField = new JTextField(5);
        menuPanel.add(radiusField, gbc);
        radiusField.setVisible(false);

        // Bouton pour dessiner
        gbc.gridy++;
        JButton drawButton = new JButton("Dessiner");
        menuPanel.add(drawButton, gbc);

        // Actions dynamiques
        figureSelection.addActionListener(e -> updateInputFields());
        drawButton.addActionListener(e -> drawFigure());

        updateInputFields(); // Affichage initial
        setVisible(true);
    }

    private void updateInputFields() {
        String selected = (String) figureSelection.getSelectedItem();

        // Nettoyer le menu
        menuPanel.removeAll();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Ajouter le menu déroulant
        gbc.gridx = 0;
        gbc.gridy = 0;
        menuPanel.add(new JLabel("Choisissez une figure :"), gbc);
        gbc.gridx = 1;
        menuPanel.add(figureSelection, gbc);

        // Ajouter les champs selon la figure sélectionnée
        int nbPoints = 0;

        if ("Cercle".equals(selected)) {
            nbPoints = 1; // Cercle a besoin d'un point + rayon

            gbc.gridx = 0;
            gbc.gridy++;
            menuPanel.add(new JLabel("Rayon :"), gbc);
            gbc.gridx = 1;
            menuPanel.add(radiusField, gbc);
            radiusField.setVisible(true);
        } else if ("Triangle".equals(selected)) {
            nbPoints = 3; // Triangle : 3 points
        } else if ("Quadrilatere".equals(selected)) {
            nbPoints = 4; // Quadrilatère : 4 points
        }

        // Ajouter dynamiquement les labels et champs pour x et y
        for (int i = 0; i < nbPoints; i++) {
            gbc.gridx = 0;
            gbc.gridy++;
            menuPanel.add(new JLabel("Point " + (i + 1) + " :"), gbc);

            gbc.gridx = 0;
            gbc.gridy++;
            menuPanel.add(new JLabel("x : "), gbc);
            gbc.gridx = 1;
            menuPanel.add(pointFields.get(i * 2), gbc);

            gbc.gridx = 0;
            gbc.gridy++;
            menuPanel.add(new JLabel("y : "), gbc);
            gbc.gridx = 1;
            menuPanel.add(pointFields.get(i * 2 + 1), gbc);
        }

        // Bouton pour dessiner
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton drawButton = new JButton("Dessiner");
        menuPanel.add(drawButton, gbc);
        drawButton.addActionListener(e -> drawFigure());

        // Bouton pour tout effacer
        gbc.gridy++;
        JButton clearButton = new JButton("Tout effacer");
        menuPanel.add(clearButton, gbc);
        clearButton.addActionListener(e -> clearFigures());


        revalidate();
        repaint();
    }

    private void clearFigures() {
        dessinPanel.effacerToutesFigures(); // Appel de la méthode pour effacer les figures
    }

    private void drawFigure() {
        String selected = (String) figureSelection.getSelectedItem();

        try {
            if ("Cercle".equals(selected)) {
                double x = Double.parseDouble(pointFields.get(0).getText());
                double y = Double.parseDouble(pointFields.get(1).getText());
                double rayon = Double.parseDouble(radiusField.getText());
                Cercle cercle = new Cercle(new Point(x, y), new Point(x + rayon, y));
                dessinPanel.ajouterCercle(cercle);
            } else if ("Triangle".equals(selected)) {
                Point p1 = new Point(Double.parseDouble(pointFields.get(0).getText()), Double.parseDouble(pointFields.get(1).getText()));
                Point p2 = new Point(Double.parseDouble(pointFields.get(2).getText()), Double.parseDouble(pointFields.get(3).getText()));
                Point p3 = new Point(Double.parseDouble(pointFields.get(4).getText()), Double.parseDouble(pointFields.get(5).getText()));
                Triangle triangle = new Triangle(p1, p2, p3);
                dessinPanel.ajouterTriangle(triangle);
            } else if ("Quadrilatere".equals(selected)) {
                Point p1 = new Point(Double.parseDouble(pointFields.get(0).getText()), Double.parseDouble(pointFields.get(1).getText()));
                Point p2 = new Point(Double.parseDouble(pointFields.get(2).getText()), Double.parseDouble(pointFields.get(3).getText()));
                Point p3 = new Point(Double.parseDouble(pointFields.get(4).getText()), Double.parseDouble(pointFields.get(5).getText()));
                Point p4 = new Point(Double.parseDouble(pointFields.get(6).getText()), Double.parseDouble(pointFields.get(7).getText()));
                Quadrilatere quadrilatere = new Quadrilatere(p1, p2, p3, p4);
                dessinPanel.ajouterQuadrilatere(quadrilatere);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Veuillez saisir des valeurs valides.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

}
