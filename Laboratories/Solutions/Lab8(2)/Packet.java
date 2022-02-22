package main_package;

public class Packet {

    PacketType.Shape shape;
    double[] dims;
    double size;


    public Packet(PacketType.Shape shape, double[] dims) {
        this.shape = shape;
        this.dims = dims;

        getSize();
    }

    public void getSize() {
        if (shape == PacketType.Shape.BOX && dims.length == 3) {
            size = dims[0] * dims[1] * dims[2];   //0 - x / 1 - y / 2 - z
        }
        if (shape == PacketType.Shape.CYLINDER && dims.length == 2) {
            size = (Math.PI) * dims[0] * dims[0] * dims[1];   //0 - promien/ 1 - wysokosc
        }
        if (shape == PacketType.Shape.SPHERE && dims.length == 1) {
            size = (4 / 3) * Math.PI * dims[0] * dims[0] * dims[0];   // 0 - promien
        }

        //     if(shape == PacketType.Shape.NEWBOX && dims.length == 2){
        //          size = ((dim[0]*dim[0]*Math.sqrt(3))/4) * dim[1]   // 0 - a  1 - height
        //     }


    }

    @Override
    public String toString() {
        if (shape == PacketType.Shape.BOX)
            return ("Box - Parameters x= " + dims[0] + " y= " + dims[1] + " z= " + dims[2] + " size= " + size);

        else if (shape == PacketType.Shape.CYLINDER)
            return ("Cylinder - Parameters ray= " + dims[0] + " height= " + dims[1] + " size= " + size);

        else if (shape == PacketType.Shape.SPHERE)
            return ("Sphere - Parameters ray= " + dims[0] + " size= " + size);

        //  if(shape == PacketType.Shape.NEWBOX )
        //       return ("NewBox - Parameters a= " + dims[0] + " height= " + dims[1] + " size= " + size);
        return "";
    }
}


