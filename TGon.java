public class TGon extends NGon {
    public TGon(Point2D[] p) {
        if (p.length != 3) throw new IllegalArgumentException("TGon must have exactly 3 points");
        this.p = p;
        this.n = 3;
    }
    public double square() {
        double a = Math.sqrt(Math.pow(Point.sub(p[1], p[0]).getX(0), 2) + Math.pow(Point.sub(p[1], p[0]).getX(1), 2));
        double b = Math.sqrt(Math.pow(Point.sub(p[2], p[1]).getX(0), 2) + Math.pow(Point.sub(p[2], p[1]).getX(1), 2));
        double c = Math.sqrt(Math.pow(Point.sub(p[0], p[2]).getX(0), 2) + Math.pow(Point.sub(p[0], p[2]).getX(1), 2));
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
