package main_package;

public class Box extends Packet {

    double x;
    double y;
    double z;

    public Box(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.size = x * y * z;
    }

    public Box(){
        this(1,2,3);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return ("Box - Parameters x= " + x + " y= " + y + " z= " + z + " size= " + size);
    }
}
