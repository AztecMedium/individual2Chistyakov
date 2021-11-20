import java.awt.geom.*;
import java.util.*;

/**
 * class for declaring a global variable "size" for getting number of points from keyboard
 */
class Size {
    public static int size;

}

/**
 * a class created to return two values (x and y) from functions
 */
class MyResult {
    private final double first;
    private final double second;

    /**
     * constructor of MyResult class
     * @param first - for x coordinate
     * @param second - for y coordinate
     */
    public MyResult(double first, double second) {
        this.first = first;
        this.second = second;
    }

    /**
     * a method that gets the first variable from MyResult object
     * @return - returns first variable
     */
    public double getFirst() {
        return first;
    }

    /**
     * a method that gets the first variable from MyResult object
     * @return - returns second variable
     */
    public double getSecond() {
        return second;
    }
}

/**
 * a class for filling in the coordinates of points and calculating the minimum distance between them in order
 * to find such a point, the sum of the distances to the remaining points from which is minimal
 */
public class MinDistance {
    static ArrayList<Point2D.Float> list = new ArrayList<>();

    /**
     * method that randomly fill coordinates for 1 point
     * @return - x and y coordinates
     */
    public static MyResult Points() {
        Random r = new Random(); // для заполнения рандомом
        Point2D.Float p = new Point2D.Float();
            p.x = r.nextFloat();
            p.y = r.nextFloat();
            list.add(p);
            System.out.println("  " + p.x + "," + p.y);
        return new MyResult(p.x*500, p.y*500);
    }

    /**
     * calculating the minimum distance between points and find a point,
     * the sum of the distances to the remaining points from which is minimal
     * @return - x and y of searchable point
     */
    public static MyResult minDistance(){

        Point2D.Float p = new Point2D.Float();
        int pos = 0;
        double minDist = Double.MAX_VALUE, d;
        for (int i = 0; i < Size.size; i++) {
            d = 0;
            p = list.get(i);
            for (int j = 0; j < Size.size; j++) {
                if (i != j) {
                    d = d + dist(p, list.get(j));
                }
            }
            if (d < minDist) {
                minDist = d;
                pos = i;
            }
        }
        System.out.print("Point with min distance: " + list.get(pos).x + "," + list.get(pos).y);
        return new MyResult(p.x*500, p.y*500);
    }

    /**
     * a function that counts the distance between 2 points by the formula
     * sqrt((x1-x2)^2 + (y1-y2)^2)
     * @param p1 first point
     * @param p2 second point
     * @return - distance between 2 points
     */
    public static double dist(Point2D.Float p1, Point2D.Float p2) {
        double dist = Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
        return dist;
    }
}
