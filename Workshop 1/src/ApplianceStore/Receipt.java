package ApplianceStore;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Receipt {

    private final String name;
    private final String address;
    private final ArrayList<Object> dev;
    private final String today;

    public Receipt(String name, String address, ArrayList<Object> dev) {
        this.name = name;
        this.address = address;
        this.dev = dev;
        Date day =new Date();
        this.today =new SimpleDateFormat("dd/mm/YYYY HH:mm:ss").format(day);
    }

    public String getToday() {
        return today;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public ArrayList<Object> getDev() {
        return dev;
    }

}
