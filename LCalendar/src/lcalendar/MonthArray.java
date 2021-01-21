package lcalendar;

public class MonthArray {

	private int firstDay;
	private int lastDay;
	private int month;
	private int year;
	private int arr[] = new int[49]; //size mirrors the grid in the app's interface - meaning the first 7 slots will never be used
	
	public MonthArray(int yr, int mth) {
		year = yr;
		month = mth;
		//populate the array and private variables with integers based on the weekdays of that month in that year
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
}
