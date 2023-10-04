public class Trapeze extends QGon {
    public Trapeze(Point2D[] p) {
        if (p.length == 4) {
            double k1 = (p[0].getX(1) - p[3].getX(1)) / (p[0].getX(0) - p[3].getX(0));
            double k2 = (p[1].getX(1) - p[2].getX(1)) / (p[1].getX(0) - p[2].getX(0));
            if (Math.abs(k1) == Math.abs(k2)) {
                this.p = p;
                this.n = p.length;
            } else throw new IllegalArgumentException("Lines must be parallel");
        } else throw new IllegalArgumentException("Trapeze must have exactly 4 points");
    }
    public double square() {
        double a = Math.sqrt(Math.pow(Point.sub(p[0], p[3]).getX(0), 2) + Math.pow(Point.sub(p[0], p[3]).getX(1), 2));
        double b = Math.sqrt(Math.pow(Point.sub(p[1], p[2]).getX(0), 2) + Math.pow(Point.sub(p[1], p[2]).getX(1), 2));
        if (a > b) { a = a + b; b = a - b; a = a - b; } // swap(a, b)
        double c = Math.sqrt(Math.pow(Point.sub(p[1], p[0]).getX(0), 2) + Math.pow(Point.sub(p[1], p[0]).getX(1), 2));
        double d = Math.sqrt(Math.pow(Point.sub(p[3], p[2]).getX(0), 2) + Math.pow(Point.sub(p[3], p[2]).getX(1), 2));
        return (a + b)/2 * Math.sqrt(Math.pow(c, 2) - Math.pow((Math.pow(c, 2) - Math.pow(d, 2))/((b - a)) + b - a, 2)/4);
    }
}