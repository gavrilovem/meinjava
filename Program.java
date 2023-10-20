import java.util.ArrayList;

public class Program
{
    public static void main(String args[])
    {
        try {
            double[] x1 = {1, 1}; Point2D c1 = new Point2D(x1);     double[] x1_ = {0, 2}; Point2D c1_ = new Point2D(x1_);
            double[] x2 = {0, 2}; Point2D s1 = new Point2D(x2);     double[] x2_ = {0, 1}; Point2D s1_ = new Point2D(x2_);
            double[] x3 = {1, 1}; Point2D s2 = new Point2D(x3);     double[] x3_ = {2, 3}; Point2D s2_ = new Point2D(x3_);
            double[] x4 = {0, 3}; Point2D pll1 = new Point2D(x4);   double[] x4_ = {0, 1}; Point2D pll1_ = new Point2D(x4_);
            double[] x5 = {2, 1}; Point2D pll2 = new Point2D(x5);   double[] x5_ = {-1, 2}; Point2D pll2_ = new Point2D(x5_);
            double[] x6 = {1, 1}; Point2D pll3 = new Point2D(x6);   double[] x51_ = {2, 3}; Point2D pll3_ = new Point2D(x51_);
                                                                    double[] x6_ = {1, 0}; Point2D pll4_ = new Point2D(x6_);
            double[] x7 = {1, 1}; Point2D ng1 = new Point2D(x7);    double[] x7_ = {5, 2}; Point2D ng1_ = new Point2D(x7_);
            double[] x8 = {2, 3}; Point2D ng2 = new Point2D(x8);    double[] x8_ = {8, 3}; Point2D ng2_ = new Point2D(x8_);
            double[] x9 = {4, 6}; Point2D ng3 = new Point2D(x9);    double[] x9_ = {9, 1}; Point2D ng3_ = new Point2D(x9_);
            double[] x10 = {3 ,0}; Point2D ng4 = new Point2D(x10);  double[] x10_ = {8, -2}; Point2D ng4_ = new Point2D(x10_);
            double[] x11 = {1, 0}; Point2D ng5 = new Point2D(x11);  double[] x11_ = {6, -2}; Point2D ng5_ = new Point2D(x11_);
                                                                    double[] x111_ = {5, -1}; Point2D ng6_ = new Point2D(x111_);
            double[] x12 = {1, 5}; Point2D tg1 = new Point2D(x12);  double[] x12_ = {1, 2}; Point2D tg1_ = new Point2D(x12_);
            double[] x13 = {2, 10}; Point2D tg2 = new Point2D(x13); double[] x13_ = {5, 1}; Point2D tg2_ = new Point2D(x13_);
            double[] x14 = {3, 8}; Point2D tg3 = new Point2D(x14);  double[] x14_ = {5, 5}; Point2D tg3_ = new Point2D(x14_);
            double[] x15 = {5, 7}; Point2D qg1 = new Point2D(x15);  double[] x15_ = {-1, 8}; Point2D qg1_ = new Point2D(x15_);
            double[] x16 = {9, 8}; Point2D qg2 = new Point2D(x16);  double[] x16_ = {2, 6}; Point2D qg2_ = new Point2D(x16_);
            double[] x17 = {10, 3}; Point2D qg3 = new Point2D(x17); double[] x17_ = {-2, 3}; Point2D qg3_ = new Point2D(x17_);
            double[] x18 = {2, 2}; Point2D qg4 = new Point2D(x18);  double[] x18_ = {-4, 5}; Point2D qg4_ = new Point2D(x18_);
            double[] x19 = {0, 4}; Point2D r1 = new Point2D(x19);   double[] x19_ = {2, 10}; Point2D r1_ = new Point2D(x19_);
            double[] x20 = {8, 10}; Point2D r2 = new Point2D(x20);  double[] x20_ = {6, 9}; Point2D r2_ = new Point2D(x20_);
            double[] x21 = {11, 6}; Point2D r3 = new Point2D(x21);  double[] x21_ = {5, 5}; Point2D r3_ = new Point2D(x21_);
            double[] x22 = {3, 0}; Point2D r4 = new Point2D(x22);   double[] x22_ = {1, 6}; Point2D r4_ = new Point2D(x22_);
            double[] x23 = {-1, 4}; Point2D t1 = new Point2D(x23);  double[] x23_ = {6, 0}; Point2D t1_ = new Point2D(x23_);
            double[] x24 = {1, 10}; Point2D t2 = new Point2D(x24);  double[] x24_ = {4, 3}; Point2D t2_ = new Point2D(x24_);
            double[] x25 = {5, 9}; Point2D t3 = new Point2D(x25);   double[] x25_ = {6, 6}; Point2D t3_ = new Point2D(x25_);
            double[] x26 = {2, 0}; Point2D t4 = new Point2D(x26);   double[] x26_ = {9, 1.5}; Point2D t4_ = new Point2D(x26_);
            
            ArrayList<IShape> list = new ArrayList<IShape>();
            list.add(new Circle(c1, 1));
            list.add(new Segment(s1, s2));
            list.add(new Polyline(new Point2D[]{pll1, pll2, pll3}));
            list.add(new NGon(new Point2D[]{ng1, ng2, ng3, ng4, ng5}));
            list.add(new TGon(new Point2D[]{tg1, tg2, tg3}));
            list.add(new QGon(new Point2D[]{qg1, qg2, qg3, qg4}));
            list.add(new Rectangle(new Point2D[]{r1, r2, r3, r4}));
            list.add(new Trapeze(new Point2D[]{t1, t2, t3, t4}));
            ArrayList<IShape> list2 = new ArrayList<IShape>();
            list2.add(new Circle(c1_, 2));
            list2.add(new Segment(s1_, s2_));
            list2.add(new Polyline(new Point2D[]{pll1_, pll2_, pll3_, pll4_}));
            list2.add(new NGon(new Point2D[]{ng1_, ng2_, ng3_, ng4_, ng5_, ng6_}));
            list2.add(new TGon(new Point2D[]{tg1_, tg2_, tg3_}));
            list2.add(new QGon(new Point2D[]{qg1_, qg2_, qg3_, qg4_}));
            list2.add(new Rectangle(new Point2D[]{r1_, r2_, r3_, r4_}));
            list2.add(new Trapeze(new Point2D[]{t1_, t2_, t3_, t4_}));
            double squares = 0;
            double length = 0;
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list2.get(i).toString() + "\n");
                squares += list.get(i).square();
                length += list.get(i).length();
            }
            System.out.println("Сумма площадей " + squares);
            System.out.println("Сумма длин " + length);
            System.out.println("Средняя площадь " + squares/list.size());
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).toString() + ";\n" + list2.get(i).toString() + ";\n" + "is crossing: " + list2.get(i).cross(list.get(i)) + "\n");
            }
            System.out.print("-----------------------------------------------------------------------\n");
            list2.set(0, (IShape)list2.get(0).shift(new Point2D(new double[]{3, 3})));
            list2.set(1, (IShape)list2.get(1).rot(1));
            list2.set(2, (IShape)list2.get(2).symAxis(0));
            list2.set(3, (IShape)list2.get(3).shift(new Point2D(new double[]{-2, 1})));
            list2.set(4, (IShape)list2.get(4).rot(0.6));
            list2.set(5, (IShape)list2.get(5).symAxis(1));
            list2.set(6, (IShape)list2.get(6).shift(new Point2D(new double[]{3, -2})));
            list2.set(7, (IShape)list2.get(7).rot(1.9));
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).toString() + ";\n" + list2.get(i).toString() + ";\n" + "is crossing: " + list2.get(i).cross(list.get(i)) + "\n");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}