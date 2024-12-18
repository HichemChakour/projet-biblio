package org.example;

public class Point {

        private double x;
        private double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public double distance(Point a) {
            return Math.sqrt(Math.pow(this.x - a.getX(), 2) + Math.pow(this.y - a.getY(), 2));
        }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}
