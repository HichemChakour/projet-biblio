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
    private final List<JLabel> pointLabels;
    private final List<JTextField> pointFields;
    private final JTextField radiusField;
    private final List<Object> figures;
    private final JComboBox<String> figuresComboBox;
    private final JTextField translationXField;
    private final JTextField translationYField;
    private final JButton translateButton;
    private int cercleCount = 0;
    private int triangleCount = 0;
    private int quadrilatereCount = 0;

    public GeometryApp() {
        setTitle("Plan 2D Géométrique");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        figures = new ArrayList<>();
        figuresComboBox = new JComboBox<>();

        dessinPanel = new DessinPanel();
        add(dessinPanel, BorderLayout.CENTER);

        menuPanel = new JPanel();
        menuPanel.setLayout(new GridBagLayout());
        menuPanel.setBorder(new TitledBorder("Options de Dessin"));
        add(menuPanel, BorderLayout.WEST);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        menuPanel.add(new JLabel("Choisissez une figure :"), gbc);

        figureSelection = new JComboBox<>(new String[]{"Cercle", "Triangle", "Quadrilatere"});
        gbc.gridx = 1;
        menuPanel.add(figureSelection, gbc);

        pointLabels = new ArrayList<>();
        pointFields = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            pointLabels.add(new JLabel());
            pointFields.add(new JTextField(5));
        }

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        menuPanel.add(new JLabel("Rayon :"), gbc);

        gbc.gridy++;
        radiusField = new JTextField(5);
        menuPanel.add(radiusField, gbc);
        radiusField.setVisible(false);

        gbc.gridy++;
        JButton drawButton = new JButton("Dessiner");
        menuPanel.add(drawButton, gbc);

        gbc.gridy++;
        menuPanel.add(new JLabel("Figures créées :"), gbc);

        gbc.gridy++;
        menuPanel.add(figuresComboBox, gbc);

        figureSelection.addActionListener(e -> updateInputFields());
        drawButton.addActionListener(e -> drawFigure());
        figuresComboBox.addActionListener(e -> highlightSelectedFigure());
        translationXField = new JTextField(5);
        translationYField = new JTextField(5);
        translateButton = new JButton("Translater");
        updateInputFields();
        setVisible(true);
    }

    private void updateInputFields() {
        String selected = (String) figureSelection.getSelectedItem();

        menuPanel.removeAll();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        menuPanel.add(new JLabel("Choisissez une figure :"), gbc);
        gbc.gridx = 1;
        menuPanel.add(figureSelection, gbc);

        int nbPoints = 0;

        if ("Cercle".equals(selected)) {
            nbPoints = 1;

            gbc.gridx = 0;
            gbc.gridy++;
            menuPanel.add(new JLabel("Rayon :"), gbc);
            gbc.gridx = 1;
            menuPanel.add(radiusField, gbc);
            radiusField.setVisible(true);
        } else if ("Triangle".equals(selected)) {
            nbPoints = 3;
        } else if ("Quadrilatere".equals(selected)) {
            nbPoints = 4;
        }

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

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton drawButton = new JButton("Dessiner");
        menuPanel.add(drawButton, gbc);
        drawButton.addActionListener(e -> drawFigure());

        gbc.gridy++;
        JButton clearButton = new JButton("Tout effacer");
        menuPanel.add(clearButton, gbc);
        clearButton.addActionListener(e -> clearFigures());

        gbc.gridy++;
        menuPanel.add(new JLabel("Figures créées :"), gbc);

        gbc.gridy++;
        menuPanel.add(figuresComboBox, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        menuPanel.add(new JLabel("Translation X :"), gbc);
        gbc.gridx = 1;
        menuPanel.add(translationXField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        menuPanel.add(new JLabel("Translation Y :"), gbc);
        gbc.gridx = 1;
        menuPanel.add(translationYField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        menuPanel.add(translateButton, gbc);
        translateButton.addActionListener(e -> translateFigure());

        revalidate();
        repaint();
    }

    private void clearFigures() {
        dessinPanel.effacerToutesFigures();
        figures.clear();
        figuresComboBox.removeAllItems();
    }

    private void drawFigure() {
        String selected = (String) figureSelection.getSelectedItem();

        try {
            if ("Cercle".equals(selected)) {
                double x = Double.parseDouble(pointFields.get(0).getText());
                double y = Double.parseDouble(pointFields.get(1).getText());
                double rayon = Double.parseDouble(radiusField.getText());
                Cercle cercle = new Cercle(new Point(x, y), new Point(x + rayon, y));
                figures.add(cercle);
                figuresComboBox.addItem("Cercle" + (++cercleCount));
                dessinPanel.ajouterCercle(cercle);
            } else if ("Triangle".equals(selected)) {
                Point p1 = new Point(Double.parseDouble(pointFields.get(0).getText()), Double.parseDouble(pointFields.get(1).getText()));
                Point p2 = new Point(Double.parseDouble(pointFields.get(2).getText()), Double.parseDouble(pointFields.get(3).getText()));
                Point p3 = new Point(Double.parseDouble(pointFields.get(4).getText()), Double.parseDouble(pointFields.get(5).getText()));
                Triangle triangle = new Triangle(p1, p2, p3);
                figures.add(triangle);
                figuresComboBox.addItem("Triangle" + (++triangleCount));
                dessinPanel.ajouterTriangle(triangle);
            } else if ("Quadrilatere".equals(selected)) {
                Point p1 = new Point(Double.parseDouble(pointFields.get(0).getText()), Double.parseDouble(pointFields.get(1).getText()));
                Point p2 = new Point(Double.parseDouble(pointFields.get(2).getText()), Double.parseDouble(pointFields.get(3).getText()));
                Point p3 = new Point(Double.parseDouble(pointFields.get(4).getText()), Double.parseDouble(pointFields.get(5).getText()));
                Point p4 = new Point(Double.parseDouble(pointFields.get(6).getText()), Double.parseDouble(pointFields.get(7).getText()));
                Quadrilatere quadrilatere = new Quadrilatere(p1, p2, p3, p4);
                figures.add(quadrilatere);
                figuresComboBox.addItem("Quadrilatere" + (++quadrilatereCount));
                dessinPanel.ajouterQuadrilatere(quadrilatere);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Veuillez saisir des valeurs valides.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void highlightSelectedFigure() {
        int selectedIndex = figuresComboBox.getSelectedIndex();
        if (selectedIndex >= 0) {
            dessinPanel.highlightFigure(figures.get(selectedIndex));
        }
    }
    private void translateFigure() {
        int selectedIndex = figuresComboBox.getSelectedIndex();
        if (selectedIndex >= 0) {
            try {
                double dx = Double.parseDouble(translationXField.getText());
                double dy = Double.parseDouble(translationYField.getText());
                Object figure = figures.get(selectedIndex);

                if (figure instanceof Cercle) {
                    ((Cercle) figure).translate(dx, dy);
                } else if (figure instanceof Triangle) {
                    ((Triangle) figure).translate(dx, dy);
                } else if (figure instanceof Quadrilatere) {
                    ((Quadrilatere) figure).translate(dx, dy);
                }

                dessinPanel.repaint();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Veuillez saisir des valeurs valides pour la translation.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}