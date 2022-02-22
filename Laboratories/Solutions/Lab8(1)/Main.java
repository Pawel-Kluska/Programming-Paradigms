package main_package;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Packet> list = new ArrayList<>();

        list.add(new Box(2,4,2));
        list.add(new Box(1,1,1));
        list.add(new Cylinder(1,2));
        list.add(new Sphere(20));

        PostOffice p = new PostOffice(10,20);

        p.writeListPackets(list);

        p.printSmall();
        p.printMedium();
        p.printBig();
    }
}
