package ApplianceStore;

import java.util.Scanner;

public class Login {

    private final Shop shop;
    private final Scanner input;

    public Login(Shop shop) {
        this.shop = shop;
        input = new Scanner(System.in);
    }

    public void LoginNewUser() {
        System.out.println("\nWe will enter the data of the new user.\n");
        System.out.println("Enter your name: ");
        String name = input.nextLine();
        System.out.println("Enter your email: ");
        String email = input.nextLine();
        System.out.println("Enter the address: ");
        String address = input.nextLine();
        System.out.println("Enter your ID: ");
        int id = 0;
        try {
            id = Integer.parseInt(input.nextLine());
            while (CheckID(id)) {
                System.out.println("Enter your ID: ");
                id = input.nextInt();
            }
        } catch (NumberFormatException e) {
            System.out.println("\\nInvalid ID\\n");
        }
        User user = new User(name, email, address, id);
        shop.users.add(user);
        shop.MainMenu(user);
    }

    public boolean CheckID(int id) {
        boolean comp = true;
        for (User user : shop.users) {
            if (id == user.getCedula()) {
                System.out.println("ID already registered");
            }
        }
        return comp;
    }

    public void LoginUser() {
        System.out.println("\nEnter your ID");
        int id = Integer.parseInt(input.nextLine());
        for (User user : shop.users) {
            if (user.getCedula() == id) {
                shop.MainMenu(user);
            }
        }
    }
}
