package lcalendar.models;

import java.util.Arrays;
import java.util.Calendar;

public class MonthArray {

    private int firstDay;
    private int lastDay;
    private int month;
    private int year;
    private int arr[] = new int[49];
	
    public MonthArray(int yr, int mth) {
        year = yr;
        month = mth;
		
        Calendar c = Calendar.getInstance();
        c.set(year, month, 1);
		
        int days = determineDays(month);
        if (isLeapYear(c) && month == 1) days += 1;
		
        //set indices of first and last day in the month array
        firstDay = LCalendar.convertWeekday(c.get(Calendar.DAY_OF_WEEK) - 1) + 7;
        lastDay = firstDay + days - 1;
		
        //populate the month being displayed
        int date = 1;
        for (int i = firstDay; i < lastDay + 1; i++) {
            arr[i] = date;
            date++;
        }
		
        //populate the grey days at the start of the calendar, but skip the first 7 entries in the array
        //(those 7 correspond to the Mo, Tu, Wed etc. day headings)
        date = determineDays(month == 0 ? 11 : month - 1) - firstDay + 8; //determine starting day
        for (int i = 7; i < firstDay; i++) {
            arr[i] = date;
            date++;
        }
		
        //populate the grey days at the end of the calendar
        date = 1;
        for (int i = lastDay + 1; i < arr.length; i++) {
            arr[i] = date;
            date++;
        }
    }
	
    public int getFirst() {
        return firstDay;
    }
	
    public int getLast() {
        return lastDay;
    }
	
    public int getMonth() {
        return month;
    }
	
    public int getYear() {
        return year;
    }
	
    public int[] getArray() {
        return arr;
    }
	
    public static boolean isLeapYear(Calendar c) { //ref https://stackoverflow.com/a/1021373/13178460
        return c.getActualMaximum(Calendar.DAY_OF_YEAR) > 365;
    }
	
    //returns the number of days in the specified month, leap years must be accounted for externally
    public int determineDays(int month) { 
        int days;
		
        if (month < 0 || month > 11) throw new IndexOutOfBoundsException(); 
		
        switch (month) {
		    case 1:
		        days = 28;
		        break;
		    case 8:
		        days = 30;
		        break;
		    case 3:
		        days = 30;
		        break;
		    case 5:
		        days = 30;
		        break;
		    case 10:
		        days = 30;
		        break;
		    default:
		        days = 31;
		        break;
        }
		
        return days;
    }
}
