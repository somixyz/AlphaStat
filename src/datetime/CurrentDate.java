/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datetime;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Milos Dragovic
 */
public class CurrentDate {

    public static String getCurrentDate(){
        Calendar cal = new GregorianCalendar();
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int mouth = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        return "Current date "+day+"/"+mouth+"/"+year;
    }
}
