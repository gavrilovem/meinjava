import java.util.ArrayList;

public class Program
{
    public static void main(String args[])
    {
        try {
            double[] x1 = {5, 4}; Point2D c1 = new Point2D(x1);
            double[] x2 = {0, 0}; Point2D t1 = new Point2D(x2);
            double[] x3 = {1, 1}; Point2D t2 = new Point2D(x3);
            double[] x4 = {3, 1}; Point2D t3 = new Point2D(x4);
            double[] x5 = {4, 0}; Point2D t4 = new Point2D(x5);
            double[] x6 = {-3, 4}; Point2D r1 = new Point2D(x6);
            double[] x7 = {-3, 9}; Point2D r2 = new Point2D(x7);
            double[] x8 = {2, 9}; Point2D r4 = new Point2D(x8);
            double[] x9 = {2, 4}; Point2D r3 = new Point2D(x9);
            double[] x10 = {4, 2}; Point2D tg1 = new Point2D(x10);
            double[] x11 = {7, 6}; Point2D tg2 = new Point2D(x11);
            double[] x12 = {1, 7}; Point2D tg3 = new Point2D(x12);
            double[] x13 = {2, 3}; Point2D tg4 = new Point2D(x13);
            double[] x14 = {1, 7}; Point2D pll1 = new Point2D(x14);
            double[] x15 = {4, 5}; Point2D pll2 = new Point2D(x15);
            double[] x16 = {3, 8}; Point2D pll3 = new Point2D(x16);
            double[] x17 = {1, 9}; Point2D pll4 = new Point2D(x17);
            double[] x18 = {3, 4}; Point2D ng1 = new Point2D(x18);
            double[] x19 = {5, 6}; Point2D ng2 = new Point2D(x19);
            double[] x20 = {9, 5}; Point2D ng3 = new Point2D(x20);
            double[] x21 = {12, 8}; Point2D ng4 = new Point2D(x21);
            double[] x22 = {5, 11}; Point2D ng5 = new Point2D(x22);
            
            ArrayList<IShape> list = new ArrayList<IShape>();
            list.add(new Circle(c1, 2));
            list.add(new Trapeze(new Point2D[]{t1,t2,t3,t4}));
            System.out.println(list.get(1).square());
            list.add(new Rectangle(new Point2D[]{r1,r2,r4,r3}));
            list.add(new TGon(new Point2D[]{tg1,tg2,tg3}));
            list.add(new QGon(new Point2D[]{tg1,tg2,tg3,tg4}));
            list.add(new NGon(new Point2D[]{ng1, ng2, ng3, ng4, ng5}));
            System.out.println(list.get(5).square());
            list.add(new Segment(pll1, pll3));
            list.add(new Polyline(new Point2D[]{pll1, pll2, pll3, pll4}));
            double squares = 0;
            double length = 0;
            for (int i = 0; i < list.size(); i++) {
                squares += list.get(i).square();
                length += list.get(i).length();
            }
            System.out.println("Сумма площадей " + squares);
            System.out.println("Сумма длин " + length);
            System.out.println("Средняя площадь " + squares/list.size());
            for (int i = 0; i < list.size(); i++) {
                IShape shape = (IShape) list.get(i).shift(t2);
                System.out.println(list.get(i).toString() + ";\n" + shape.toString() + ";\n" + "is crossing: " + shape.cross(list.get(i)) + "\n");
            }
            for (int i = 0; i < list.size(); i++) {
                IShape shape = (IShape) list.get(i).rot(Math.PI/2);
                System.out.println(list.get(i).toString() + ";\n" + shape.toString() + ";\n" + "is crossing: " + shape.cross(list.get(i)) + "\n");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
// TODO Circle crossing with lines working incorrectly
// 