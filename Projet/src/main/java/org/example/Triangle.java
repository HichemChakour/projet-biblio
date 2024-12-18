package org.example;

public class Triangle implements ICalculMethods{
    private final Point p1;
    private final Point p2;
    private final Point p3;

    public Triangle(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    @Override
    public double getAire() {
        double base = p1.distance(p2);
        double hauteur = Math.abs((p2.getY() - p1.getY()) * p3.getX() - (p2.getX() - p1.getX()) * p3.getY() + p2.getX() * p1.getY() - p2.getY() * p1.getX()) /
                Math.sqrt(Math.pow(p2.getY() - p1.getY(), 2) + Math.pow(p2.getX() - p1.getX(), 2));
        return (base * hauteur) / 2;
    }

    @Override
    public double getAire(int arrondi) {
        double aire = this.getAire();
            return Arrondi.arrondi(aire, arrondi);
    }


    @Override
    public double getPerimetre() {
        return p1.distance(p2) + p2.distance(p3) + p3.distance(p1);
    }

    @Override
    public double getPerimetre(int arrondi) {
        double perimetre =this.getPerimetre();
            return Arrondi.arrondi(perimetre, arrondi);

    }

    public Point getP2() {
        return p2;
    }

    public Point getP1() {
        return p1;
    }

    public Point getP3() {
        return p3;
    }

    @Override
    public boolean estInterieur(Point point) {
        // Aire originale
        double aireOriginale = this.getAire();

        // Aires des trois sous-triangles
        Triangle t1 = new Triangle(point, p2, p3);
        Triangle t2 = new Triangle(p1, point, p3);
        Triangle t3 = new Triangle(p1, p2, point);

        double aireTotale = t1.getAire() + t2.getAire() + t3.getAire();

        // Vérification avec tolérance pour éviter les erreurs d'arrondi
        return Math.abs(aireOriginale - aireTotale) < 1e-9;
    }
    public void translate(double dx, double dy) {
        p1.setX(p1.getX() + dx);
        p1.setY(p1.getY() + dy);
        p2.setX(p2.getX() + dx);
        p2.setY(p2.getY() + dy);
        p3.setX(p3.getX() + dx);
        p3.setY(p3.getY() + dy);
    }
    public void rotate(Point center, double angle) {
    double radians = Math.toRadians(angle);
    rotatePoint(p1, center, radians);
    rotatePoint(p2, center, radians);
    rotatePoint(p3, center, radians);
}

private void rotatePoint(Point p, Point center, double radians) {
    double dx = p.getX() - center.getX();
    double dy = p.getY() - center.getY();
    double newX = center.getX() + dx * Math.cos(radians) - dy * Math.sin(radians);
    double newY = center.getY() + dx * Math.sin(radians) + dy * Math.cos(radians);
    p.setX(newX);
    p.setY(newY);
}

}
