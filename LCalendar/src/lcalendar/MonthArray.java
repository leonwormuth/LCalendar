package lcalendar;

public class MonthArray {

	private int firstDay;
	private int lastDay;
	private int monthId;
	private int arr[] = new int[49];
	
	public MonthArray(int month, int year) {
		//populate the array and private variables with integers based on the weekdays of that month in that year
	}
	
	public int getFirst() {
		return firstDay;
	}
	
	public int getLast() {
		return lastDay;
	}
	
	public int getMonth() {
		return monthId;
	}
	
	public int[] getArray() {
		return arr;
	}
}
