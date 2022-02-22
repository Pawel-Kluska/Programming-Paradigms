package main_package;

import java.util.ArrayList;

public class PostOffice {

    int min;
    int max;

    ArrayList<Packet> small;
    ArrayList<Packet> medium;
    ArrayList<Packet> big;

    PostOffice(int min,int max){
        this.min = min;
        this.max = max;

        small = new ArrayList<>();
        medium = new ArrayList<>();
        big = new ArrayList<>();
    }

    PostOffice(){
        this(5,10);
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void writeListPackets(ArrayList<Packet> list){
        for(int i=0; i<list.size(); i++){
            writePacket(list.get(i));
        }
    }

    public void writePacket(Packet packet){
        if(packet.size < min)
            small.add(packet);

        else if(packet.size > max)
            big.add(packet);

        else
            medium.add(packet);
    }

    public void printSmall(){

        System.out.println();
        for(int i=0; i<small.size(); i++){
            System.out.print(small.get(i) + " ");
        }
    }

    public void printMedium(){

        System.out.println();
        for(int i=0; i<medium.size(); i++){
            System.out.print(medium.get(i) + " ");
        }
    }

    public void printBig(){

        System.out.println();
        for(int i=0; i<big.size(); i++){
            System.out.print(big.get(i) + " ");
        }
    }

    public ArrayList<Packet> getSmall() {
        return small;
    }


    public ArrayList<Packet> getMedium() {
        return medium;
    }


    public ArrayList<Packet> getBig() {
        return big;
    }

}
