import java.util.ArrayList;

class Hotel {

    private final int Capacity = 34;
    private int size = 0;

    private ArrayList<Request> mas = new ArrayList<Request>();
    private ArrayList<Request> arr = new ArrayList<Request>(); // list of waiting people
    private Type type = new Type();

    Hotel() {
    }

    public synchronized boolean add(Request ob) {
        if ((size < Capacity) & (type.Sort(ob)))
            return true;
        else
            return false;
    }
    public void Sort(Request ob) {
           type.makeInsert(ob);
           makeRequest(ob);
    }
    public synchronized void makeRequest(Request ob) {
        mas.add(ob);
        if (ob.getSurname() != null) {
            System.out.println("_______________________________________");
            System.out.println("Поселился: " + ob.getSurname() + "\n" + "Время проживания: " + ob.getTime() + " milliseconds" +
                    '\n' + "Номер категории: " + ob.getTypeofRoom() + '\n' + "Мест в номере: " + ob.getPlaces());
            System.out.println("_______________________________________");
            System.out.println("Осталось мест: " + (Capacity - (size+=ob.getPlaces())));
        }
        else
        {
            System.out.println("_______________________________________");
            System.out.println("Поселилась группа из " + ob.getSurnameOfGroup().size() + " человек:");
            for (int i = 0; i < ob.getSurnameOfGroup().size(); i++) {
                 System.out.println(i+1 + ". " +ob.getSurnameOfGroup().get(i));
            }
            System.out.println("Время проживания: " + ob.getTime() + " milliseconds" + '\n' + "Номер категории: " +ob.getTypeofRoom() +
                    '\n' + "Мест в номере: " + ob.getPlaces());
            System.out.println("_______________________________________");
            System.out.println("Осталось мест: " + (Capacity - (size+=ob.getPlaces())));
        }
    }
    public synchronized void Wait(Request ob) {
        if (ob.getSurname() != null)
            System.out.println("Ожидает: " + ob.getSurname());
        else
        {
            System.out.println("Ожидает группа: ");
            for (int i = 0; i < ob.getSurnameOfGroup().size(); i++) {
                System.out.println(i + 1 + ". " + ob.getSurnameOfGroup().get(i));
            }
        }
            arr.add(ob);
    }
    public synchronized void Check(Request ob) {
        if (!arr.isEmpty())
            for (int i = 0; i < arr.size(); i++) {
                if ((arr.get(i).getTypeofRoom().compareTo(ob.getTypeofRoom()) == 0) & (add(ob)) &
                        (arr.get(i).getPlaces() == ob.getPlaces())) {
                    System.out.println("Ожидаемый номер класса: " + arr.get(i).getTypeofRoom() + " освободился." + '\n' +
                            "Мест в номере: " + ob.getPlaces());
                    synchronized (arr.get(i)) {
                        arr.get(i).notify();
                        arr.remove(i);
                    }
                    break;
                }
            }
    }
    public synchronized void Remove(Request ob) {
        if (ob.getSurname() != null) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Выселился: " + ob.getSurname() + '\n' + "Время проживания: " + ob.getTime() + " milliseconds" + '\n' +
                    "Номер категории: " + ob.getTypeofRoom() + '\n' + "Мест в номере: " + ob.getPlaces());
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
        else {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Выселилась группа из " + ob.getSurnameOfGroup().size() + " человек:");
            for (int i = 0; i < ob.getSurnameOfGroup().size(); i++) {
                System.out.println(i + 1 + ". " + ob.getSurnameOfGroup().get(i));
            }
            System.out.println("Время проживания: " + ob.getTime() + " milliseconds" + '\n' + "Номер категории: " + ob.getTypeofRoom() +
                    '\n' + "Мест в номере: " + ob.getPlaces());
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        }
        type.makeDelete(ob);
        mas.remove(ob);
        System.out.println("Осталось мест: " + (Capacity - (size-=ob.getPlaces())));
        Check(ob);
    }
}
