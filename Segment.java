public class Segment extends OpenFigure {
    protected Point2D start;
    protected Point2D finish;
    public Segment(Point2D s, Point2D f) {
        this.start = s;
        this.finish = f;
    }
    public Point2D getStart() {
        return start;
    }
    public void setStart(Point2D a) {
        this.start = a;
    } 
    public Point2D getFinish() {
        return finish;
    }
    public void setFinish(Point2D a) {
        this.finish = a;
    }
    public double length() {
        return Math.sqrt(Math.pow(start.sub(finish).getX(0), 2) + Math.pow(start.sub(finish).getX(1), 2));
    }
    public boolean cross(IShape i) {
            if (i instanceof Segment) {
                Point2D[] pi = new Point2D[] {((Segment) i).getStart(), ((Segment) i).getFinish()};
                for (int ji = 1; ji < pi.length; ji++) {
                if (Point2D.linesIntersect(start, finish, pi[ji], pi[ji - 1])) {
                    return true;
                }
            }
            return false;
            } else throw new IllegalArgumentException("Unsupported data argument provided");
    }
    public Segment shift(Point2D a) {
        return new Segment(new Point2D(start.add(a).getX()), new Point2D(finish.add(a).getX()));
    }
    public Segment rot(double phi) {
        return new Segment(new Point2D(start.rot(phi).getX()), new Point2D(finish.rot(phi).getX()));
    }
    public Segment symAxis(int i) {
        return new Segment(new Point2D(start.symAxis(i).getX()), new Point2D(finish.symAxis(i).getX()));
    }
    public String toString() {
        return "Segment: {start: " + start.toString() + "; " + "finish: " + finish.toString() +  "}";
    }
}