public interface IShape extends IMoveable {
    double square();
    double length();
    boolean cross(IShape i);
}