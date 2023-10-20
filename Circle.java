public class Circle implements IShape {
    protected Point2D p;
    protected double r;
    public Circle(Point2D p, double r) {
        if (p == null) throw new IllegalArgumentException("Point can't be null");
        if (r <= 0) throw new IllegalArgumentException("Radius must be non-negative and more than zero");
        this.p = p;
        this.r = r;
    }
    public Point2D getP() {
        return p;
    }
    public void setP(Point2D p) {
        this.p = p;
    }
    public double getR() {
        return r;
    }
    public void setR(double r) {
        if (r <= 0) throw new IllegalArgumentException("Radius must be non-negative and more than zero");
        this.r = r;
    }
    public double square() {
        return Math.PI * r * r;
    }
    public double length() {
        return 2 * Math.PI * r;
    }
    public Circle shift(Point2D a) {
        return new Circle(new Point2D(p.add(a).getX()), r);
    }
    public Circle rot(double phi) {
        return new Circle(new Point2D(p.rot(phi).getX()), r);
    }
    public Circle symAxis(int i) {
        return new Circle(new Point2D(p.symAxis(i).getX()), r);
    }
    public boolean cross(IShape i) throws IllegalArgumentException {
        if (i instanceof Circle) {
            Circle in = (Circle) i;
            Point2D center = in.getP();
            if (Math.sqrt(Math.pow(p.getX(0) - center.getX(0), 2) + Math.pow(p.getX(1) - center.getX(1), 2)) <= in.getR() + this.r) {
                return true;
            }
            return false;
        } else throw new IllegalArgumentException("Argument nust be type of Circle");
    }
    public String toString() {
        return "Circle: {" + "r: " + r + "; p: " + p.toString() + "}";
    }
}