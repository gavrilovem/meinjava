public class Rectangle extends QGon {
    public Rectangle(Point2D[] p) {
        if (p.length == 4) {
            for (int i = 0; i < p.length; i++) {
                if (p[i] == null) throw new IllegalArgumentException("Points can't be null");
            }
            double k1 = (p[0].getX(1) - p[3].getX(1)) / (p[0].getX(0) - p[3].getX(0));
            double k2 = (p[1].getX(1) - p[2].getX(1)) / (p[1].getX(0) - p[2].getX(0));
            double k3 = (p[2].getX(1) - p[1].getX(1)) / (p[2].getX(0) - p[1].getX(0));
            double k4 = (p[3].getX(1) - p[0].getX(1)) / (p[3].getX(0) - p[0].getX(0));
            if (k1 == k2 && k3 == k4) {
                this.p = p;
                this.n = p.length;
            } else throw new IllegalArgumentException("Opposite sides of rectangle must be parallel");
        } else throw new IllegalArgumentException("Rectangle must have exactly 4 points");
    }
}