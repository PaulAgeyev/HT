import java.util.ArrayList;
class Request implements Runnable {

    Thread t;
    Hotel h;

    ArrayList <String> NameOfPeoples;
    String surname;
    long time;
    String TypeofRoom;
    int places;

    Request (Hotel h, String surname, long time, String TypeofRoom, int places) {
        this.surname = surname;
        this.time = time;
        this.TypeofRoom = TypeofRoom;
        this.places = places;
        this.h = h;
        t = new Thread(this);

        if ((this.getPlaces() >= 1 && this.getPlaces() <= 3) &
                ((this.getTypeofRoom() == "Economy") | (this.getTypeofRoom() == "Standard")
                | (this.getTypeofRoom() == "Business") | (this.getTypeofRoom() == "Suite")))
            t.start();
        else
            System.out.println("Заявка " + this.getSurname() + " отклонена.");
    }
    Request (Hotel h, ArrayList <String> NameOfPeoples, long time, String TypeofRoom, int places) {
        this.NameOfPeoples = NameOfPeoples;
        this.time = time;
        this.TypeofRoom = TypeofRoom;
        this.places = places;
        this.h = h;
        t = new Thread(this);

        if ((this.getPlaces() >= 1 && this.getPlaces() <= 3) &
                ((this.getTypeofRoom() == "Economy") | (this.getTypeofRoom() == "Standard")
                | (this.getTypeofRoom() == "Business") | (this.getTypeofRoom() == "Suite")))
            t.start();
        else
        {
            System.out.println("Заявка группы: ");
            for (int i = 0; i < this.getSurnameOfGroup().size(); i++)
                System.out.println(i+1 + ". " + this.getSurnameOfGroup().get(i));
            System.out.println("Отклонена.");
        }
    }
    public void run() {
        synchronized (this) {
            if (!h.add(this)) {
                h.Wait(this);
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            }
            h.Sort(this);
            try {
                Thread.sleep(time);
            }
            catch (InterruptedException e) {
            }
            h.Remove(this);
        }
    }
    public String getSurname () {
        return surname;
    }
    public ArrayList <String> getSurnameOfGroup () {
        return NameOfPeoples;
    }
    public long getTime () {
        return time;
    }
    public String getTypeofRoom() {
        return TypeofRoom;
    }
    public int getPlaces() {
        return places;
    }
}
