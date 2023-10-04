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

    public Point2D getP(int i) throws IndexOutOfBoundsException {
        if (i < n && i >= 0) {
            return p[i];
        } else throw new IndexOutOfBoundsException("Non-exsistent index " + i);
    }

    public void setP(Point2D[] p) {
        this.p = p;
    }

    public void setP(Point2D p, int i) throws IndexOutOfBoundsException {
        if (i < n && i >= 0) {
            this.p[i] = p;
        } else throw new IndexOutOfBoundsException("Non-exsistent index " + i);
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
        try {
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
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        return false;
    }

    public String toString() {
        String s = "NGon: { " + "n: " + n + "; p: ";
        for (int i = 0; i < n; i++) {
            s += p[i].toString();
        };
        return s + " }";
    }
}