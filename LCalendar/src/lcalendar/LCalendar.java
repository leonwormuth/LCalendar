package lcalendar;

import java.util.Date;
import java.util.Calendar;

public class LCalendar {

	private int day;
	private int month;
	private int year;
	private int weekday;
	private MonthArray prevMonth;
	private MonthArray currentMonth;
	private MonthArray nextMonth;
		
	public LCalendar() {
		init();
	}
	
	private void init() {
		//populate current, prev, and next month
		Calendar cal = Calendar.getInstance();
		day = cal.get(Calendar.DAY_OF_MONTH);
		month = cal.get(Calendar.MONTH);
		year = cal.get(Calendar.YEAR);
		weekday = convertWeekday(cal.get(Calendar.DAY_OF_WEEK));
		
		currentMonth = new MonthArray(year, month);
		prevMonth = new MonthArray(month == 0 ? year - 1 : year, month == 0 ? 11 : month - 1);
		nextMonth = new MonthArray(month == 11 ? year + 1 : year, month == 11 ? 0 : month + 1);
	}
	
	public static int convertWeekday(int i) { //to convert Calendar.DAY_OF_WEEK to 0 index and Mon-Sun format
		int day;
		
		if (i < 0 || i > 6) throw new IndexOutOfBoundsException();
		
		if (i == 0) {
			day = 6;
		} else {
			day = i - 1;
		}
		
		return day;
	}
	
	public MonthArray prevMonth() {
		nextMonth = currentMonth;
		currentMonth = prevMonth;
		prevMonth = new MonthArray(
			prevMonth.getMonth() == 0 ? prevMonth.getYear() - 1 : prevMonth.getYear(),
			prevMonth.getMonth() == 0 ? 11 : prevMonth.getMonth() - 1
		);
		
		return currentMonth;
	}
	
	public MonthArray nextMonth() {
		prevMonth = currentMonth;
		currentMonth = nextMonth;
		nextMonth = new MonthArray(
			nextMonth.getMonth() == 11 ? nextMonth.getYear() + 1 : nextMonth.getYear(),
			nextMonth.getMonth() == 11 ? 0 : nextMonth.getMonth() + 1
		);

		return currentMonth;
	}

	public MonthArray now() {
		init();
		return currentMonth;
	}
}
