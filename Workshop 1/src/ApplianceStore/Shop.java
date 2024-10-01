/**
 * This module will try to recreate an application for purchasing electronic devices.
 *
 * Copyright (C) 2024  Juan David Mayorga Lopez <jeidenmayo13752@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
/**
 * This class represents an appliance store.
 *
 * Args:
 *  input (Scanner): Allows me to enter the data.
 *  receipts (ArrayList<Receipt>): Keep the receipts made. shCart (ArrayList): It
 * is the shopping cart where the chosen devices are stored. com (boolean): It
 * is used in some menus.
 *
 */
package ApplianceStore;

import java.util.ArrayList;
import java.util.Scanner;

public final class Shop {

    private final Scanner input;
    private final ArrayList<Receipt> receipts;
    private ArrayList shCart;
    private boolean com;

    public Shop() {
        input = new Scanner(System.in);
        shCart = new ArrayList();
        receipts = new ArrayList();
        MainMenu();
    }

    public void MainMenu() {
        /* This method recreates the main menu of the application.
     *
     * In this method we will decide what to do in the application,
     * whether it is paying bills, adding devices to the shopping cart and 
     * reviewing bills that have already been paid.
     *   
     * Args:
     *
     * Returns:
     * 
         */
        com = true;
        while (com) {
            System.out.println("""
                           
                           What do you want to do?:
                               1. Choose devices.
                               2. Pay cart devices.
                               3. Consult invoices;
                               4. Exit. 
                           """);
            try {
                switch (Integer.parseInt(input.nextLine())) {
                    case 1 ->
                        DevicesMenu();
                    case 2 -> {
                        if (!shCart.isEmpty()) {
                            PayCartDevices();
                        } else {
                            System.out.println("\nNo devices in the cart.");
                        }
                    }
                    case 3 -> {
                        if (!receipts.isEmpty()) {
                            ConsultInvoices();
                        } else {
                            System.out.println("\nNo invoices recorded.");
                        }
                    }
                    case 4 -> {
                        System.out.println("\nThank you for using the program.\n");
                        System.exit(0);
                    }
                    default -> {
                        System.out.println("\nInvalid option\n");
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid option\n");
            }
        }
    }

    public void DevicesMenu() {
        /* Menu to see the devices.
     *
     *With this method you will choose how you want to see the devices
     *   
     * Args:
     *
     * Returns:
     * 
         */
        System.out.println("""
                           
                           How do you want to search for your device?:
                               1. Show all.
                               2. Category.
                               3. Exit. 
                           """);
        try {
            switch (Integer.parseInt(input.nextLine())) {
                case 1 ->
                    AllDevices();
                case 2 ->
                    Devicescategory();
                case 3 ->
                    MainMenu();
                default -> {
                    System.out.println("\nInvalid option\n");
                    DevicesMenu();
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("\nInvalid option\n");
            DevicesMenu();
        }
    }

    public void AllDevices() {
        /* This method will show all devices.
     *
     *This method will show me all the devices and 
     allow me to add them to the shopping cart.
     *   
     * Args:
     *  i (int): serves as an accountant.
     *  sel (int): Choose which option you want to choose from the menu.
     * Returns:
     * 
         */
        com = true;
        System.out.println("""
                           
                           All devices in the storen:
                           
                           """);
        int i = 1;
        for (SmartHomeDevices smartHome : SmartHomeDevices.values()) {
            System.out.println(i + " " + smartHome.name());
            i++;
        }
        for (ComputersAccessories ComAc : ComputersAccessories.values()) {
            System.out.println(i + " " + ComAc.name());
            i++;
        }
        for (PhonesAccessories PhoAc : PhonesAccessories.values()) {
            System.out.println(i + " " + PhoAc.name());
            i++;
        }
        while (com) {
            try {
                System.out.println("""
                                   
                                   Choose which of the devices you want to 
                                   add to the shopping cart or select 0 to exit.
                                   
                                   """);
                int sel = Integer.parseInt(input.nextLine());

                if (sel <= 5 && sel > 0) {
                    i = 0;
                    for (SmartHomeDevices smartHome : SmartHomeDevices.values()) {
                        if ((sel - 1) == i) {
                            shCart.add(smartHome);
                            System.out.println("Successfully added: " + smartHome.name() + "\n");
                        }
                        i++;
                    }
                } else if (sel > 5 && sel <= 10) {
                    i = 0;
                    for (ComputersAccessories ComAc : ComputersAccessories.values()) {
                        if ((sel - 6) == i) {
                            shCart.add(ComAc);
                            System.out.println("Successfully added: " + ComAc.name() + "\n");
                        }
                        i++;
                    }
                } else if (sel > 10 && sel <= 15) {
                    i = 0;
                    for (PhonesAccessories PhoAc : PhonesAccessories.values()) {
                        if ((sel - 11) == i) {
                            shCart.add(PhoAc);
                            System.out.println("Successfully added: " + PhoAc.name() + "\n");
                        }
                        i++;
                    }
                } else if (sel == 0) {
                    com = false;
                } else {
                    System.out.println("\nInvalid option\n");
                }

            } catch (NumberFormatException e) {
                System.out.println("\nInvalid option\n");
            }
        }
        DevicesMenu();
    }

    public void Devicescategory() {
        /* This method is a menu categories.
     *
     * menu that allows me to choose which category
     * I want to see and allows me to add devices to the shopping cart
     *   
     * Args:
     *  i (int): serves as an accountant.
     * Returns:
     * 
         */
        System.out.println("""
                                       
                           Choose Category:
                               1. Computers and Accessories.
                               2. Phones and Accessories.
                               3. Smart Home Devices. 
                               4. Exit. 
                           """);
        try {
            com = true;
            switch (Integer.parseInt(input.nextLine())) {
                case 1 -> {
                    int i = 1;
                    System.out.println("""
                                               
                                               Category:
                                               Computers and Accessories.
                                               """);
                    for (ComputersAccessories ComAc : ComputersAccessories.values()) {
                        System.out.println(i + " " + ComAc.name());
                        i++;
                    }
                    while (com) {
                        System.out.println("""
                                   
                                   Choose which of the devices you want to 
                                   add to the shopping cart or select 0 to exit.
                                   
                                   """);
                        try {
                            int sel = Integer.parseInt(input.nextLine());
                            i = 0;
                            if (sel > 0 && sel <= 5) {
                                for (ComputersAccessories ComAc : ComputersAccessories.values()) {
                                    if ((sel - 1) == i) {
                                        shCart.add(ComAc);
                                        System.out.println("Successfully added: " + ComAc.name() + "\n");
                                    }
                                    i++;
                                }
                            } else if (sel == 0) {
                                com = false;
                            } else {
                                System.out.println("\nInvalid option\n");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("\nInvalid option\n");
                        }
                    }
                    Devicescategory();
                }

                case 2 -> {
                    int i = 1;
                    System.out.println("""
                                               
                                               Category:
                                               Phones and Accessories.
                                               """);
                    for (PhonesAccessories PhoAc : PhonesAccessories.values()) {
                        System.out.println(i + " " + PhoAc.name());
                        i++;
                    }
                    while (com) {
                        System.out.println("""
                                   
                                   Choose which of the devices you want to 
                                   add to the shopping cart or select 0 to exit.
                                   
                                   """);
                        try {
                            int sel = Integer.parseInt(input.nextLine());
                            i = 0;
                            if (sel > 0 && sel <= 5) {
                                for (PhonesAccessories PhoAc : PhonesAccessories.values()) {
                                    if ((sel - 1) == i) {
                                        shCart.add(PhoAc);
                                        System.out.println("Successfully added: " + PhoAc.name() + "\n");
                                    }
                                    i++;
                                }
                            } else if (sel == 0) {
                                com = false;
                            } else {
                                System.out.println("\nInvalid option\n");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("\nInvalid option\n");
                        }
                    }
                    Devicescategory();
                }
                case 3 -> {
                    int i = 1;
                    System.out.println("""
                                               
                                               Category:
                                               Smart Home Devices.
                                               """);
                    for (SmartHomeDevices smartHome : SmartHomeDevices.values()) {
                        System.out.println(i + " " + smartHome.name());
                        i++;
                    }
                    while (com) {
                        System.out.println("""
                                   
                                   Choose which of the devices you want to 
                                   add to the shopping cart or select 0 to exit.
                                   
                                   """);
                        try {
                            int sel = Integer.parseInt(input.nextLine());
                            i = 0;
                            if (sel > 0 && sel <= 5) {
                                for (SmartHomeDevices smartHome : SmartHomeDevices.values()) {
                                    if ((sel - 1) == i) {
                                        shCart.add(smartHome);
                                        System.out.println("Successfully added: " + smartHome.name() + "\n");
                                    }
                                    i++;
                                }
                            } else if (sel == 0) {
                                com = false;
                            } else {
                                System.out.println("\nInvalid option\n");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("\nInvalid option\n");
                        }
                    }
                    Devicescategory();
                }
                case 4 ->
                    DevicesMenu();
                default -> {
                    System.out.println("\nInvalid option\n");
                    Devicescategory();
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("\nInvalid option\n");
            Devicescategory();
        }
    }

    public void PayCartDevices() {
        /* This method pays for devices in the shopping cart.
     *
     * This method allows me to pay for the devices in the 
     * shopping cart and empties it.
     *   
     * Args:
     *
     * Returns:
     * 
         */
        com = true;
        System.out.println("""
                           
                           Devices in the shopping cart:
                           
                           """);
        for (Object receipt : shCart) {
            System.out.println(receipt);
        }
        while (com) {
            System.out.println("""
                           
                           Want to pay:
                             1.yes.
                             2.No.
                               
                           """);
            try {
                switch (Integer.parseInt(input.nextLine())) {
                    case 1 -> {
                        PayDevices();
                        System.out.println("\nSuccessfully generated invoice.");
                        shCart = new ArrayList();
                        com = false;
                    }
                    default -> {
                        com = false;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid option\n");
            }
        }
        MainMenu();
    }

    public void PayDevices() {
        /* This method creates the invoice.
     *
     * This method requests the user's data and creates the invoice.
     *   
     * Args:
     * name (String): username.
     * address (String): user address.
     *
     * Returns:
     * 
         */
        System.out.println("""
                           
                           Enter your details to be able to ship.
                           
                           """);
        System.out.println("Enter your name: ");
        String name = input.nextLine();
        System.out.println("Enter the address: ");
        String address = input.nextLine();
        Receipt receipt = new Receipt(name, address, shCart);
        receipts.add(receipt);
    }

    public void ConsultInvoices() {
        /* This method allows me to see paid invoices.
     *
     * This method searches in "receipt" and shows all the invoices.
     *   
     * Args:
     * i (int): serves as an accountant.
     * Returns:
     * 
         */
        com = true;
        System.out.println("""
                           
                           These are all the invoices generated.
                           
                           """);
        int i = 1;
        for (Receipt receipt : receipts) {
            System.out.println(i + "  " + receipt.getToday());
            i++;
        }
        while (com) {
            System.out.println("""
                               
                               Choose the invoice to review or enter 0 to exit.
                               
                               """);
            try {
                int sel = Integer.parseInt(input.nextLine());
                if (sel > 0 && sel <= receipts.size()) {
                    Receipt receipt = receipts.get(sel - 1);
                    System.out.println("""
                                       
                                       #=======================================
                                                     INVOICE
                                       """);
                    System.out.println("\nName: " + receipt.getName()
                            + "\nAddress: " + receipt.getAddress()
                            + "\nDate and Time: " + receipt.getToday());
                    System.out.println("""
                                                                           
                                                PURCHASED DEVICES
                                       
                                       """);
                    for (Object dev : receipts.get(sel - 1).getDev()) {
                        System.out.println(dev);
                    }
                    System.out.println("""
                                       
                                       #=======================================
                                       
                                       """);
                } else if (sel == 0) {
                    com = false;
                } else {
                    System.out.println("\nInvalid option\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid option\n");
            }
        }
        MainMenu();
    }

}
