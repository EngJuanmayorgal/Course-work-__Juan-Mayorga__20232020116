
package ApplianceStore;

import java.util.ArrayList;

public class User {
    private String name;
    private String email;
    private String address;
    private int id;
    private ArrayList shoppingCart;
    private ArrayList listInvoices;

    public User(String name, String email, String address, int id) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.id = id;
        shoppingCart=new ArrayList();
        listInvoices=new ArrayList();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public int getCedula() {
        return id;
    }

    public ArrayList getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ArrayList shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public ArrayList getListInvoices() {
        return listInvoices;
    }

    public void setListInvoices(ArrayList listInvoices) {
        this.listInvoices = listInvoices;
    }
    
    
}
