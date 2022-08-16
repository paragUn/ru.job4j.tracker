package ru.job4j.oop;

import static java.lang.Math.sqrt;

public class Triangle {
    private Point first;
    private Point second;
    private Point third;

    public Triangle(Point ap, Point bp, Point cp) {
        this.first = ap;
        this.second = bp;
        this.third = cp;
    }

    public double semiPerimeter(Point ap, Point bp, Point cp) {
        return (ap.distance(bp) + bp.distance(cp) + cp.distance(ap)) / 2;
    }

    public boolean exist(Point ap, Point bp, Point cp) {
        return ap.distance(bp) + bp.distance(cp) > cp.distance(ap)
               && bp.distance(cp) + cp.distance(ap) > ap.distance(bp)
               && cp.distance(ap) + ap.distance(bp) > bp.distance(cp);
    }

    public double area() {
        double rsl = -1;
        double ab = first.distance(second);
        double ac = first.distance(third);
        double bc = second.distance(third);
        if (this.exist(first, second, third)) {
            double p = semiPerimeter(first, second, third);
            rsl = sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return rsl;
    }
}
