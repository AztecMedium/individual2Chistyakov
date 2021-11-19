import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.*;
import java.util.Scanner;

/**
 * the main class that calls methods for filling points, calculating point with a minimum distance,
 * and drawing points in a graphical window
 */
public class DrawPoint2D extends Applet {
    static MyResult[] p;
    static MyResult p1;

    /**
     * getting num of points from keyboard and call out all methods that needed
     * @param args - default command-line arguments in Java
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите число точек: ");
        Size.size = sc.nextInt();
        if(Size.size < 3) {
            System.out.print("To find a point with min\ndistance you need at least 3 points");
            System.exit(0);
        }
        p = new MyResult[Size.size];
        for (int i = 0; i < Size.size; i++){
            p[i] = MinDistance.Points();
        }
        p1 = MinDistance.minDistance();
        Frame DrawPoint2D = new Frame("Draw Point2D");
        DrawPoint2D.setSize(525, 545);
        Applet DrawPoint2DExample = new DrawPoint2D();
        DrawPoint2D.add(DrawPoint2DExample);
        DrawPoint2D.setVisible(true);
        DrawPoint2D.addWindowListener(new WindowAdapter() {
            /**
             * event method which ends the program when window is closed
             * @param e WindowEvent object
             */
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    /**
     * paints all points as circles through Ellipse2D
     * @param g - Graphics object
     */
    public void paint(Graphics g) {
            g.setColor(Color.blue);
            Graphics2D G2D = (Graphics2D)g;
            G2D.setStroke(new BasicStroke(2.0f));
            Ellipse2D P2D;
            Ellipse2D P12D;
            for (int i = 0; i < Size.size; i++){
                P2D = new Ellipse2D.Double(p[i].getFirst(), p[i].getSecond(),10,10);
                G2D.draw(P2D);
            }
            g.setColor(Color.red);
            P12D = new Ellipse2D.Double(p1.getFirst(), p1.getSecond(),10,10);
            G2D.draw(P12D);
    }
}