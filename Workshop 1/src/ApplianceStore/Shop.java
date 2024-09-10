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
    private ArrayList listSurveys;

    public Shop() {
        input = new Scanner(System.in);
        listSurveys = new ArrayList();
        MainMenu();
    }

    public void MainMenu() {
        System.out.println("""                           
                           \n\nWhat you want to do:
                              1.Ask students.
                              2.View student interviews.
                              3.Buy electronic devices.
                              4.Exit""");
        try {
            System.out.println("Type the option: ");
            switch (Integer.parseInt(input.nextLine())) {
                case 1 -> {
                    AskStudents();
                }
                case 2 ->
                    ViewStudentInterviews();
                case 3 ->
                    System.out.println("3");
                case 4 -> {
                    System.out.println("4");
                    System.out.println("\n\nThank you Goodbye");
                }

                default ->
                    System.out.println("\nInvalid option\n");
            }
        } catch (NumberFormatException e) {
            System.out.println("\nInvalid option\n");
        }
    }

    public void AskStudents() {
        for (int i = 0; i < 15; i++) {
            System.out.println("\nStudent N_" + (i + 1));
            System.out.println("\nEnter your name:");
            String name = input.nextLine();
            System.out.println("\nWhat does he do:");
            String office = input.nextLine();
            System.out.println("\nwhich device would you like us to add to our catalog:");
            String device = input.nextLine();
            System.out.println("\nWhat you want to do with this device:");
            String action = input.nextLine();
            listSurveys.add("I " + name + " as " + office + " I want a " + device + " to " + action);

        }
        System.out.println("\n\nCompleted questions");
        MainMenu();
    }

    public void ViewStudentInterviews() {
        for (int i = 0; i < listSurveys.size(); i++) {
            System.out.println("\nStudent N_"+(i+1)+"\n "+listSurveys.get(i));
        }
        MainMenu();
    }
}
