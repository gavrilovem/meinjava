public class Point {
    protected int dim;
    protected double x[];
    public Point(int dim) {
        this.dim = dim;
        this.x = new double[dim];
    }
    public Point(int dim, double x[]) throws IllegalArgumentException {
        if (dim > 0) this.dim = dim;
        else throw new IllegalArgumentException("Dimension must be a non-negative value");
        if (x.length == dim) this.x = x;
        else throw new IllegalArgumentException("Specified dimension and quantity of points must be equal");
    }
    public int getDim() {
        return dim;
    }
    public double[] getX() {
        return x.clone();
    }
    public double getX(int i) {
        return x[i];
    }
    public void setX(double x[]) {
        if (dim == x.length) {
            this.x = x;
        }
    }
    public void setX(double x, int i) {
        this.x[i] = x;
    }
    public double abs() {
        int res = 0;
        for (int i = 0; i < dim; i++) {
            res += x[i]*x[i];
        }
        return Math.sqrt(res);
    }
    public static Point add(Point a, Point b) throws IllegalArgumentException{
        if (a.getDim() == b.getDim()) {
            double ax[] = a.getX();
            double bx[] = b.getX();
            for (int i = 0; i < ax.length; i++) {
                ax[i] += bx[i];
            }
            return new Point(a.getDim(), ax); 
        } else throw new IllegalArgumentException("Dimensions of Point a and Point b must be equal");
    }
    public Point add(Point b) {
        return add(this, b);
    }
    public static Point sub(Point a, Point b) throws IllegalArgumentException {
        if (a.getDim() == b.getDim()) {
            double ax[] = a.getX();
            double bx[] = b.getX();
            for (int i = 0; i < ax.length; i++) {
                ax[i] -= bx[i];
            }
            return new Point(a.getDim(), ax); 
        } else throw new IllegalArgumentException("Dimensions of Point a and Point b must be equal");
    }
    public Point sub(Point b) {
        return sub(this, b);
    }
    public static Point multi(Point a, double r) {
        double[] nx = a.getX();
        for (int i = 0; i < nx.length; i++) {
            nx[i] *= r;
        }
        return new Point(a.getDim(), nx);
    }
    public Point multi(double r) {
        return multi(this, r);
    }
    public static double multi(Point a, Point b) throws IllegalArgumentException {
        if (a.getDim() == b.getDim()) {
            double res = 0;
            double[] ax = a.getX();
            double[] bx = b.getX();
            for (int i = 0; i < ax.length; i++) {
                res += ax[i] * bx[i];
            }
            return res;
        } else throw new IllegalArgumentException("Dimensions of Point a and Point b must be equal");
    }
    public double multi(Point b) {
        return multi(this, b);
    }
    public static Point symAxis(Point a, int i) {
        if (i < 0 || i >= a.getDim()) throw new IllegalArgumentException("Specified axis doesnt exist");
        double x[] = a.getX(); 
        for (int j = 0; j < a.getDim(); j++) {
            if (j != i) x[j] = -x[j];
        }
        return new Point(x.length, x);
    }
    public Point symAxis(int i) {
        return symAxis(this, i);
    }
    public String toString() {
        String s = "{ dim: " + dim + "; ";
        for (int i = 0; i < dim; i++) {
            s += x[i] + " ";
        }
        return s + "}";
    }
}