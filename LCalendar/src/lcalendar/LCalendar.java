package lcalendar;

import java.util.Date;

public class LCalendar {

	private Date todaysDate;
	private MonthArray prevMonth;
	private MonthArray currentMonth;
	private MonthArray nextMonth;
		
	public LCalendar(Date date) {
		todaysDate = date;
		init();
	}
	
	private void init() {
		//populate current, prev, and next month
	}
	
	public MonthArray prevMonth() {
		return currentMonth;
	}
	
	public MonthArray nextMonth() {
		return currentMonth;
	}

	public MonthArray now() {
		init();
		return currentMonth;
	}
}
