/**
 * This module recreates an invoice.
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
 * This class represents an invoice.
 *
 * Args:
 *  name (String): username.
 *  address (String): user address.
 *  dev (ArrayList): save store shopping cart devices.
 *  today (String): date the invoice was made.
 * 
 */
package ApplianceStore;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Receipt {

    private final String name;
    private final String address;
    private final ArrayList dev;
    private final String today;

    public Receipt(String name, String address, ArrayList dev) {
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

    public ArrayList getDev() {
        return dev;
    }

}
