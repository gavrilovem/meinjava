public interface IMoveable {
    public IMoveable shift(Point2D a);
    public IMoveable rot(double phi);
    public IMoveable symAxis(int i);
}