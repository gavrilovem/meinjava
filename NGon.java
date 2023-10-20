public class NGon implements IPolyPoint, IShape {
    protected int n;
    protected Point2D[] p;
    protected NGon() {}
    public NGon(Point2D[] p) {
        if (p == null) throw new IllegalArgumentException("Points can't be null");
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
        if (i < n && i >= 0) {
            return p[i];
        } else throw new IllegalArgumentException("Non-exsistent index " + i);
    }

    public void setP(Point2D[] p) {
        this.p = p;
    }

    public void setP(Point2D p, int i) throws IllegalArgumentException {
        if (i < n && i >= 0) {
            this.p[i] = p;
        } else throw new IllegalArgumentException("Non-exsistent index " + i);
    }

    public double square() {
        double sum = p[n - 1].getX(0) * p[0].getX(1) - p[n - 1].getX(1) * p[0].getX(0);
        for (int i = 1; i < n; i++) {
            sum += p[i - 1].getX(0) * p[i].getX(1) - p[i - 1].getX(1) * p[i].getX(0);
        }
        return Math.abs(sum) / 2;
    }

    public double length() {
        double l = Math.sqrt(Math.pow(p[0].sub(p[n-1]).getX(0), 2) + Math.pow(p[0].sub(p[n-1]).getX(1), 2));
        for (int i = 1; i < n; i++) {
            l += Math.sqrt(Math.pow(p[i].sub(p[i-1]).getX(0), 2) + Math.pow(p[i].sub(p[i-1]).getX(1), 2)); // sqrt((x1 - x2)^2 + (y1- y2)^2)
        }
        return l;
    }

    public NGon shift(Point2D a) {
        Point2D[] np = p.clone();
        for (int i = 0; i < n; i++) {
            np[i] = new Point2D(np[i].add(a).getX());
        }
        return new NGon(np);
    }

    public NGon rot(double phi) {
        Point2D[] np = p.clone();
        for (int i = 0; i < n; i++) {
            np[i] = new Point2D(np[i].rot(phi).getX());
        }
        return new NGon(np);
    }

    public NGon symAxis(int i) {
        Point2D[] np = p.clone();
        for (int j = 0; j < n; j++) {
            np[j] = new Point2D(np[j].symAxis(i).getX());
        }
        return new NGon(np);
    }

    public boolean cross(IShape i) {
            if (i instanceof NGon) {
                Point2D[] pi = ((NGon) i).getP();
                for (int j = 1; j < n; j++) {
                    for (int ji = 1; ji < pi.length; ji++) {
                        if (Point2D.linesIntersect(p[j - 1], p[j], pi[ji], pi[ji - 1])) {
                            return true;
                        }
                    }
                    if (Point2D.linesIntersect(p[j - 1], p[j], pi[0], pi[pi.length - 1])) {
                        return true;
                    }
                }
                for (int ji = 1; ji < pi.length; ji++) {
                    if (Point2D.linesIntersect(p[p.length - 1], p[0], pi[ji], pi[ji - 1])) {
                        return true;
                    }
                }
                if (Point2D.linesIntersect(p[p.length - 1], p[0], pi[0], pi[pi.length - 1])) {
                    return true;
                }
                return false;
            } else throw new IllegalArgumentException("Argument must be type of NGon");
    }

    public String toString() {
        String s = "NGon: { " + "n: " + n + "; p: ";
        for (int i = 0; i < n; i++) {
            s += p[i].toString();
        };
        return s + " }";
    }
}