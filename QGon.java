public class QGon extends NGon {
    protected QGon() {}
    public QGon(Point2D[] p) {
        if (p.length != 4) throw new IllegalArgumentException("QGon figure must have exactly 4 points");
        if (!Point2D.linesIntersect(p[0], p[2], p[1], p[3])) throw new IllegalArgumentException("Diagonals of QGon must intersect");
        this.p = p;
        this.n = p.length;
    }
    public double square() {
        double a = Math.sqrt(Math.pow(Point.sub(p[0], p[1]).getX(0), 2) + Math.pow(Point.sub(p[0], p[1]).getX(1), 2));
        double b = Math.sqrt(Math.pow(Point.sub(p[1], p[2]).getX(0), 2) + Math.pow(Point.sub(p[1], p[2]).getX(1), 2));
        double c = Math.sqrt(Math.pow(Point.sub(p[2], p[3]).getX(0), 2) + Math.pow(Point.sub(p[2], p[3]).getX(1), 2));
        double d = Math.sqrt(Math.pow(Point.sub(p[3], p[0]).getX(0), 2) + Math.pow(Point.sub(p[3], p[0]).getX(1), 2));
        double diag = Math.sqrt(Math.pow(Point.sub(p[0], p[2]).getX(0), 2) + Math.pow(Point.sub(p[0], p[2]).getX(1), 2));
        double p1 = (a + b + diag) / 2;
        double p2 = (diag + c + d) / 2;
        return Math.sqrt(p1 * (p1 - a) * (p1 - b) * (p1 - diag)) + Math.sqrt(p2 * (p2 - diag) * (p2 - c) * (p2 - d));
    }
}