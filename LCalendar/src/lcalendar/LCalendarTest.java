package lcalendar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LCalendarTest {
	
	@Test
	void getYearTest() {
		LCalendar cal = new LCalendar();
		MonthArray m = cal.now();
		int result = m.getYear();
		assertEquals(2021, result);
	}
	
	@Test
	void getFirstTest() {
		LCalendar cal = new LCalendar();
		MonthArray m = cal.now();
		int result = m.getFirst();
		System.out.println(result);
		assertEquals(11, result);
	}
	
	@Test
	void getLastTest() {
		LCalendar cal = new LCalendar();
		MonthArray m = cal.now();
		int result = m.getLast();
		System.out.println(result);
		assertEquals(41, result);
	}
	
	@Test
	void prevMonthTest() {
		LCalendar cal = new LCalendar();
		MonthArray m = cal.prevMonth();
		int result = m.getMonth();
		assertEquals(11, result);
	}
	
	@Test
	void nowTest() {
		LCalendar cal = new LCalendar();
		MonthArray m = cal.now();
		int result = m.getMonth();
		assertEquals(0, result);
	}
	
	@Test
	void nextMonthTest() {
		LCalendar cal = new LCalendar();
		MonthArray m = cal.nextMonth();
		int result = m.getMonth();
		assertEquals(1, result);
	}
}
