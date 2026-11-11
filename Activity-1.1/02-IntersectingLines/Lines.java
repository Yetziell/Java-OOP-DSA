import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lines {

    private Point start;
    private Point end;

    public Lines(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    private static double orientation(Point a, Point b, Point c) {
        return (b.getX() - a.getX()) * (c.getY() - a.getY())
             - (b.getY() - a.getY()) * (c.getX() - a.getX());
    }

    private static boolean onSegment(Point a, Point b, Point c) {
        return c.getX() >= Math.min(a.getX(), b.getX())
            && c.getX() <= Math.max(a.getX(), b.getX())
            && c.getY() >= Math.min(a.getY(), b.getY())
            && c.getY() <= Math.max(a.getY(), b.getY());
    }

    public boolean intersects(Lines other) {

        Point a = this.start;
        Point b = this.end;
        Point c = other.start;
        Point d = other.end;

        double o1 = orientation(a, b, c);
        double o2 = orientation(a, b, d);
        double o3 = orientation(c, d, a);
        double o4 = orientation(c, d, b);

        if (((o1 > 0 && o2 < 0) || (o1 < 0 && o2 > 0))
         && ((o3 > 0 && o4 < 0) || (o3 < 0 && o4 > 0))) {
            return true;
        }

        if (o1 == 0 && onSegment(a, b, c)) return true;
        if (o2 == 0 && onSegment(a, b, d)) return true;
        if (o3 == 0 && onSegment(c, d, a)) return true;
        if (o4 == 0 && onSegment(c, d, b)) return true;

        return false;
    }

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(new File("points.txt"))) {

            Point pointA = new Point(scanner.nextDouble(), scanner.nextDouble());
            Point pointB = new Point(scanner.nextDouble(), scanner.nextDouble());
            Point pointC = new Point(scanner.nextDouble(), scanner.nextDouble());
            Point pointD = new Point(scanner.nextDouble(), scanner.nextDouble());

            Lines line1 = new Lines(pointA, pointB);
            Lines line2 = new Lines(pointC, pointD);

            if (line1.intersects(line2)) {
                System.out.println("The two lines intersect.");
            } else {
                System.out.println("The two lines do not intersect.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: points.txt not found.");
        }
    }
}
