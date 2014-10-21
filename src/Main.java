import java.util.ArrayList;
class Main {
    public static void main (String [] args) throws InterruptedException {

        Request request [] = new Request [20];

        Hotel h = new Hotel();

        request [0] = new Request(h,"Ageyev", 10000, "Suite",1);
        Thread.sleep(150);
        request [1] = new Request(h,"Starun",7000, "Suite",1);
        Thread.sleep(1010);
        request [2] = new Request(h,"Mazurik",25000, "Suite",1);
        Thread.sleep(1020);
        request [3] = new Request(h,"Bondarenko",12000, "Standard",1);
        Thread.sleep(2001);
        request [4] = new Request(h,"Visockaya",17000, "Business",1);
        Thread.sleep(1540);
        request [5] = new Request(h,"Luneva",8000, "Suite",1);
        Thread.sleep(120);
        request [6] = new Request(h,"Kovalenko",9000, "Economy",1);
        Thread.sleep(2000);
        request [7] = new Request(h,"Krutienko",7000,"Economy",1);
        Thread.sleep(1050);

        ArrayList <String> Group1 = new ArrayList<String>();
        Group1.add("Ermolenko");
        Group1.add("Liftuhov");
        Group1.add("Marchenko");
        request [8] = new Request(h, Group1, 10000, "Economy", Group1.size());
        Thread.sleep(500);


        request [9] = new Request(h,"Ivanchenko",6500,"Standard",2);
        Thread.sleep(800);
        request [10] = new Request(h,"Makaveckii",5500,"Standard",1);
        Thread.sleep(1300);

        ArrayList<String> Group2 = new ArrayList<String>();
        Group2.add("Jobs");
        Group2.add("Brown");
        Group2.add("Scofield");
        request [11] = new Request(h, Group2, 10000, "Business", Group2.size());
        Thread.sleep(3000);

        ArrayList<String> Group3 = new ArrayList<String>();
        Group3.add("Mahone");
        Group3.add("Lincoln");
        Group3.add("Sarah");
        request [12] = new Request(h, Group3, 12000, "Business", Group3.size());
        Thread.sleep(800);

        ArrayList<String> Group4 = new ArrayList<String>();
        Group4.add("Tsyganok");
        Group4.add("Noormal");
        request [13] = new Request(h, Group4, 12000, "Business", Group4.size());
        Thread.sleep(850);

        request [14] = new Request(h,"Krolivec",7000,"Business",2);
        Thread.sleep(2200);
        request [15] = new Request(h,"Marchenko",7000,"Business",2);
        Thread.sleep(2200);
        request [16] = new Request(h,"Sherba",9000,"Economy",1);
        Thread.sleep(1400);
        request [17] = new Request(h,"Yakovenko",15000,"Suite",1);
        Thread.sleep(1100);
        request [18] = new Request(h,"Ilinov",7000,"Business",1);
        Thread.sleep(2100);
        request [19] = new Request(h,"Korotun",5000,"Economy",1);
    }
}
