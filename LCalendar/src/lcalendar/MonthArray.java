package lcalendar;

import java.util.Calendar;

public class MonthArray {

	private int firstDay;
	private int lastDay;
	private int month;
	private int year;
	private int arr[] = new int[49]; //size mirrors the grid in the app's interface - meaning the first 7 slots will never be used
	
	public MonthArray(int yr, int mth) {
		year = yr;
		month = mth;
		int days = determineDays(month);
		
		Calendar c = Calendar.getInstance();
		c.set(year, month, 1);
		
		//set indices of first and last day in the month array
		firstDay = LCalendar.convertWeekday(c.get(Calendar.DAY_OF_WEEK) - 1) + 7;
		lastDay = firstDay + days - 1;
		
		//TODO populate the array based on first day, last day, and whatever month comes before and after
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
	
	private int determineDays(int month) {
		int days;
		
		if (month < 0 || month > 11) throw new IndexOutOfBoundsException(); 
		
		switch (month) {
			case 1:
				days = 28;
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
