/**
 * This module will try to recreate some options of an appliance store.
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
 */
package ApplianceStore;

import java.util.ArrayList;
import java.util.Scanner;

public class Shop {

    private final Scanner input;
    private User userLogin;
    protected ArrayList<User> users;
    private final Login log;

    public Shop() {
        input = new Scanner(System.in);
        users = new ArrayList();
        log = new Login(this);
    }

    public void MenuEnter() {
        System.out.println("""
                           Do you already have an account?
                               1.Yes.
                               2.No.  
                               3.End program.
                           """);
        try {
            switch (Integer.parseInt(input.nextLine())) {
                case 1 ->
                    log.LoginUser();
                case 2 ->
                    log.LoginNewUser();
                case 3 ->
                    System.out.println("Thanks for using the program");
                default ->
                    System.out.println("\\nInvalid option\\n");
            }
        } catch (NumberFormatException e) {
            System.out.println("\\nInvalid option\\n");
        }
    }

    public void MainMenu(User userLogin) {
        this.userLogin = userLogin;
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
                case 2 ->
                    PayCartDevices();
                case 3 ->
                    MenuEnter();
                default ->
                    System.out.println("\\nInvalid option\\n");
            }
        } catch (NumberFormatException e) {
            System.out.println("\\nInvalid option\\n");
        }
    }

    public void DevicesMenu() {
    }

    public void PayCartDevices() {
    }

}
