public class Point2D extends Point {
    public Point2D() {
        super(2);
    }
    public Point2D(double x[]) {
        super(2, x);
    }
    public static Point2D rot(Point2D p, double phi) {
        double[] x = p.getX();
        return new Point2D(new double[]{x[0] * Math.cos(phi) - x[1] * Math.sin(phi), x[0] * Math.sin(phi) + x[1] * Math.cos(phi)});
    }
    public Point2D rot(double phi) {
        return rot(this, phi);
    }
    /**
     * Проверка на пересечение двух отрезков
     * @param a начало отрезка 1
     * @param b конец отрезка 1
     * @param c начало отрезка 2
     * @param d конец отрезка 2
     * @return bool
     */
    public static boolean linesIntersect(Point2D a, Point2D b, Point2D c, Point2D d) {
        Point2D main = new Point2D(Point.sub(b, a).getX());
        Point2D v1 = new Point2D(Point.sub(c, a).getX());
        Point2D v2 = new Point2D(Point.sub(d, a).getX());
        double product1 = main.getX(0) * v1.getX(1) - main.getX(1) * v1.getX(0);
        double product2 = main.getX(0) * v2.getX(1) - main.getX(1) * v2.getX(0);
        if (product1>=0&&product2<=0 || product1<=0&&product2>=0) {
            main = new Point2D(Point.sub(d, c).getX());
            v1 = new Point2D(Point.sub(a, c).getX());
            v2 = new Point2D(Point.sub(b, c).getX());
            product1 = main.getX(0) * v1.getX(1) - main.getX(1) * v1.getX(0);
            product2 = main.getX(0) * v2.getX(1) - main.getX(1) * v2.getX(0);
            return (product1>=0&&product2<=0 || product1<=0&&product2>=0);
        }
        return false;
    }
    /**
     * @param a первая точка отрезка
     * @param b вторая точка отрезка
     * @param p точка, от которой находится расстояние до отрезка
     * @return расстояние от точки до отрезка
     * https://wikimedia.org/api/rest_v1/media/math/render/svg/be2ab4a9d9d77f1623a2723891f652028a7a328d
     */
    public static double pointToLineDistance(Point2D a, Point2D b, Point2D p) {
        double t = (Point.sub(p, a).getX(0) * Point.sub(b, a).getX(0) + Point.sub(p, a).getX(1) * Point.sub(b, a).getX(1))/
                    Math.pow(Point.sub(b, a).getX(0), 2) + Math.pow(Point.sub(b, a).getX(1), 2) < 0 ? 0 : 1;
        return Math.sqrt(Math.pow(Point.sub(a, p).getX(0) + Point.sub(b, a).getX(0)*t, 2) + Math.pow(Point.sub(a, p).getX(1) + Point.sub(b, a).getX(1)*t, 2));
    }
}