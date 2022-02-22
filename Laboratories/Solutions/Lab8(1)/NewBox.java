package main_package;

public class NewBox extends Packet{

    double a;
    double height;

    public NewBox(double a, double height) {
        this.a = a;
        this.height = height;
        this.size = ((a*a*Math.sqrt(3))/4)*6 * height;
    }

    public NewBox(){
        this(1,1);
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return (" Parameters a= " + a + " height= " + height + " size= " + size);
    }
}
