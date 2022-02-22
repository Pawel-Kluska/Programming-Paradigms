package main_package;

public class Cylinder extends Packet{

    double ray;
    double height;

    public Cylinder(double ray, double height) {
        this.ray = ray;
        this.height = height;
        this.size = (Math.PI)* ray*ray * height;
    }

    public Cylinder(){
        this(2,3);
    }

    public double getRay() {
        return ray;
    }

    public void setRay(double ray) {
        this.ray = ray;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return ("Cylinder - Parameters ray= " + ray + " height= " + height + " size= " + size);
    }
}
