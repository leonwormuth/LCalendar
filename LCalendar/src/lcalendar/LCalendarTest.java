package lcalendar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lcalendar.models.LCalendar;
import lcalendar.models.MonthArray;

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
		assertEquals(11, result);
	}
	
	@Test
	void getLastTest() {
		LCalendar cal = new LCalendar();
		MonthArray m = cal.now();
		int result = m.getLast();
		assertEquals(41, result);
	}
	
	@Test
	void determineDaysTest() {
		LCalendar cal = new LCalendar();
		MonthArray m = cal.now();
		int result = m.determineDays(1);
		assertEquals(28, result);
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
