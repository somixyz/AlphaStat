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
public class CurrentDateAndTime {
private static final Calendar cal = new GregorianCalendar();
    public static String getCurrentDate(){ 
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int mouth = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        return "Current date "+day+"/"+mouth+1+"/"+year;
    }
    
    public static String getCurrentTime(){
        int second = cal.get(Calendar.SECOND);
        int minutes = cal.get(Calendar.MINUTE);
        int hour = cal.get(Calendar.HOUR);
        return "Logged time: "+hour+" h : "+minutes+" min : "+second+" sec";
    }
}
