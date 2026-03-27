public class Point3D {
    private RationalFraction x;
    private RationalFraction y;
    private RationalFraction z;

    public Point3D(RationalFraction x, RationalFraction y, RationalFraction z) {
        this.x = new RationalFraction(x);
        this.y = new RationalFraction(y);
        this.z = new RationalFraction(z);
    }

    public Point3D(long x, long y, long z) {
        this(new RationalFraction(x), new RationalFraction(y), new RationalFraction(z));
    }

    public Point3D(int x, int y, int z) {
        this(new RationalFraction(x), new RationalFraction(y), new RationalFraction(z));
    }

    public Point3D() {
        this(new RationalFraction(0), new RationalFraction(0), new RationalFraction(0));
    }

    public Point3D(Point3D other) {
        this(other.x, other.y, other.z);
    }

    public RationalFraction getX() {
        return new RationalFraction(x);
    }

    public RationalFraction getY() {
        return new RationalFraction(y);
    }

    public RationalFraction getZ() {
        return new RationalFraction(z);
    }

    public void setX(RationalFraction x) {
        this.x = new RationalFraction(x);
    }

    public void setY(RationalFraction y) {
        this.y = new RationalFraction(y);
    }

    public void setZ(RationalFraction z) {
        this.z = new RationalFraction(z);
    }

    public double distanceToOrigin() {
        // d = √(x² + y² + z²)
        double xSquared = x.multiply(x).toDouble();
        double ySquared = y.multiply(y).toDouble();
        double zSquared = z.multiply(z).toDouble();
        return Math.sqrt(xSquared + ySquared + zSquared);
    }

    public double distanceTo(Point3D other) {
        // d = √((x2-x1)² + (y2-y1)² + (z2-z1)²)
        RationalFraction dx = this.x.subtract(other.x);
        RationalFraction dy = this.y.subtract(other.y);
        RationalFraction dz = this.z.subtract(other.z);

        double dxSquared = dx.multiply(dx).toDouble();
        double dySquared = dy.multiply(dy).toDouble();
        double dzSquared = dz.multiply(dz).toDouble();

        return Math.sqrt(dxSquared + dySquared + dzSquared);
    }

    public static boolean areCollinear(Point3D p1, Point3D p2, Point3D p3) {

        RationalFraction abX = p2.x.subtract(p1.x);
        RationalFraction abY = p2.y.subtract(p1.y);
        RationalFraction abZ = p2.z.subtract(p1.z);

        RationalFraction acX = p3.x.subtract(p1.x);
        RationalFraction acY = p3.y.subtract(p1.y);
        RationalFraction acZ = p3.z.subtract(p1.z);

        RationalFraction crossX = abY.multiply(acZ).subtract(abZ.multiply(acY));
        RationalFraction crossY = abZ.multiply(acX).subtract(abX.multiply(acZ));
        RationalFraction crossZ = abX.multiply(acY).subtract(abY.multiply(acX));

        double epsilon = 1e-10;
        return Math.abs(crossX.toDouble()) < epsilon &&
                Math.abs(crossY.toDouble()) < epsilon &&
                Math.abs(crossZ.toDouble()) < epsilon;
    }

    public static boolean areCollinearByArea(Point3D p1, Point3D p2, Point3D p3) {

        RationalFraction abX = p2.x.subtract(p1.x);
        RationalFraction abY = p2.y.subtract(p1.y);
        RationalFraction abZ = p2.z.subtract(p1.z);

        RationalFraction acX = p3.x.subtract(p1.x);
        RationalFraction acY = p3.y.subtract(p1.y);
        RationalFraction acZ = p3.z.subtract(p1.z);

        RationalFraction crossX = abY.multiply(acZ).subtract(abZ.multiply(acY));
        RationalFraction crossY = abZ.multiply(acX).subtract(abX.multiply(acZ));
        RationalFraction crossZ = abX.multiply(acY).subtract(abY.multiply(acX));

        double squaredLength = crossX.multiply(crossX).toDouble() +
                crossY.multiply(crossY).toDouble() +
                crossZ.multiply(crossZ).toDouble();

        double epsilon = 1e-10;
        return squaredLength < epsilon;
    }

    @Override
    public String toString() {
        return String.format("Point(%.2f, %.2f, %.2f)", x.toDouble(), y.toDouble(), z.toDouble());
    }

    // Форматированный вывод с рациональными дробями
    public String toRationalString() {
        return String.format("Point(%s, %s, %s)", x.toString(), y.toString(), z.toString());
    }
}