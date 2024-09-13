package ApplianceStore;

import java.util.ArrayList;

public class Receipt {

    private final String name;
    private final String address;
    private final ArrayList dev;

    public Receipt(String name, String address, ArrayList dev) {
        this.name = name;
        this.address = address;
        this.dev = dev;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public ArrayList getDev() {
        return dev;
    }

}
