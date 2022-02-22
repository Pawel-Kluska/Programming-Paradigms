package main_package;

public class Sphere extends Packet {

    double ray;

    public Sphere(double ray) {
        this.ray = ray;
        this.size = (4/3) * Math.PI * ray * ray * ray;
    }

    public Sphere(){
        this(2);
    }

    public double getRay() {
        return ray;
    }

    public void setRay(double ray) {
        this.ray = ray;
    }

    @Override
    public String toString() {
        return ("Sphere - Parameters ray= " + ray + " size= " + size);
    }
}
