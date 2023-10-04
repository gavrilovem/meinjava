public class Point3D extends Point {
    public Point3D() {
        super(3);
    }
    public Point3D(double[] x) {
        super(3, x);
    }
    public static Point3D cross_prod(Point3D p1, Point3D p2) {
        double[] x1 = p1.getX();
        double[] x2 = p2.getX();
        double[] x = {x1[1]*x2[2] - x1[2]*x2[1],
                      x1[2]*x2[0] - x1[0]*x2[2],
                      x1[0]*x2[1] - x1[1]*x2[0]};
        return new Point3D(x);
    }
    public Point3D cross_prod(Point3D p) {
        return cross_prod(this, p);
    }
    public static double mix_prod(Point3D p1, Point3D p2, Point3D p3) {
        double[] x1 = p1.getX();
        double[] x2 = p2.getX();
        double[] x3 = p3.getX();
        return x1[0] * x2[1] * x3[2] + x3[0] * x1[1] * x2[2] + x1[2] * x2[0] * x3[1] -
                x1[2] * x2[1] * x3[0] - x3[2] * x1[1] * x2[0] + x1[0] * x2[2] * x3[1];
    }
    public double mix_prod(Point3D p1, Point3D p2) {
        return mix_prod(this, p1, p2);
    }
}