public class Polyline extends OpenFigure implements IPolyPoint {
    protected int n;
    protected Point2D[] p;
    public Polyline(Point2D[] p) {
        for (int i = 0; i < p.length; i++) {
            if (p[i] == null) throw new IllegalArgumentException("Points can't be null");
        }
        this.p = p;
        this.n = p.length;
    }
    public int getN() {
        return n;
    }
    public Point2D[] getP() {
        return p.clone();
    }
    public Point2D getP(int i) throws IllegalArgumentException {
        if (i < n && i >= 0) return p[i];
        else throw new IllegalArgumentException("Non-existent index " + i);
    }
    public void setP(Point2D[] p) throws IllegalArgumentException {
        if (p.length == n) {
            this.p = p;
        } else throw new IllegalArgumentException("Array length and Polyline.p array length must be equal");
    }
    public void setP(Point2D p, int i) throws IllegalArgumentException {
        if (i >= 0 && i < n) {
            this.p[i] = p;
        } else throw new IllegalArgumentException("Non-exsistent index: " + i);
    }
    public double length() {
        double l = 0;
        for (int i = 1; i < n; i++) {
            l += Math.sqrt(Math.pow(p[i].sub(p[i-1]).getX(0), 2) + Math.pow(p[i].sub(p[i-1]).getX(1), 2)); // sqrt((x1 - x2)^2 + (y1- y2)^2)
        }
        return l;
    }
    public Polyline shift(Point2D a) {
        Point2D[] np = new Point2D[n];
        for (int i = 0; i < n; i++) {
            np[i] = new Point2D(p[i].add(a).getX());
        }
        return new Polyline(np);
    }
    public Polyline rot(double phi) {
        Point2D[] np = new Point2D[n];
        for (int i = 0; i < n; i++) {
            np[i] = new Point2D(p[i].rot(phi).getX());
        }
        return new Polyline(p);
    }
    public Polyline symAxis(int i) {
        Point2D[] np = new Point2D[n];
        for (int j = 0; j < n; j++) {
            np[i] = new Point2D(p[i].symAxis(i).getX());
        }
        return new Polyline(p);
    }
    public boolean cross(IShape i) throws IllegalArgumentException {
        if (i instanceof Circle) {
            Circle in = (Circle) i;
            for (int j = 1; j < n; j++) {
                if (Point2D.pointToLineDistance(p[j], p[j-1], in.getP()) <= in.getR()) {
                    return true;
                }
            }
            return false;
        }
        Point2D[] pi;
        if (i instanceof Polyline) pi = ((Polyline) i).getP();
        else if (i instanceof NGon) pi = ((NGon) i).getP();
        else if (i instanceof Segment) {
            pi = new Point2D[2];
            pi[0] = ((Segment) i).getStart();
            pi[1] = ((Segment) i).getFinish();
        } else throw new IllegalArgumentException("Unsupported data argument provided");

        for (int j = 1; j < n; j++) {
            for (int ji = 1; ji < pi.length; ji++) {
                if (Point2D.linesIntersect(p[j - 1], p[j], pi[ji], pi[ji - 1])) {
                    return true;
                }
            }
        }
        return false;
    }
    public String toString() {
        String s = "Polyline: {" + "n: " + n + "; p: ";
        for (int i = 0; i < n; i++) {
            s += p[i].toString();
        };
        return s + "}";
    }
}