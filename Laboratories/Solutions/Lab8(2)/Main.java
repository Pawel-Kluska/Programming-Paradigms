package main_package;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Packet> list = new ArrayList<>();
        double[] tab1 = new double[3];
        double[] tab2 = new double[3];
        double[] tab3 = new double[2];
        double[] tab4 = new double[1];

        tab1[0] = 2; tab1[1] = 4; tab1[2] = 2;
        tab2[0] = 1; tab2[1] = 1; tab2[2] = 1;
        tab3[0] = 1; tab3[1] = 2;
        tab4[0] = 20;

        list.add(new Packet(PacketType.Shape.BOX,tab1));
        list.add(new Packet(PacketType.Shape.BOX,tab2));
        list.add(new Packet(PacketType.Shape.CYLINDER,tab3));
        list.add(new Packet(PacketType.Shape.SPHERE,tab4));

        PostOffice p = new PostOffice(10,20);

        p.writeListPackets(list);

        p.printSmall();
        p.printMedium();
        p.printBig();

    }
}
