import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

/**
 * Tests for an implementation of the holiday lookup interface.
 *
 * @author Jason Heard
 * @version 1.0
 */
public class HolidayLookupTests {

	/**
	 * Constructs a new holiday lookup object. This should be updated to construct
	 * your class.
	 *
	 * @return The holiday lookup implementation to test.
	 */
	public static MyHolidayLookup makeHolidayLookup() {
		return new MyHolidayLookup();
	}

	/**
	 * Tests that the get holidays method works for Alberta in 2022.
	 */
	@Test
	public void getHolidaysWorksForAlberta() {
		HolidayLookup holidayLookup = makeHolidayLookup();

		List<Holiday> albertaHolidays = holidayLookup.getHolidays(2022, Province.Alberta);

		assertEquals(14, albertaHolidays.size());

		assertEquals("New Year's Day", albertaHolidays.get(0).getName());
		assertEquals(LocalDate.of(2022, 1, 1), albertaHolidays.get(0).getDate());

		assertEquals("Family Day", albertaHolidays.get(1).getName());
		assertEquals(LocalDate.of(2022, 2, 21), albertaHolidays.get(1).getDate());

		assertEquals("Good Friday", albertaHolidays.get(2).getName());
		assertEquals(LocalDate.of(2022, 4, 15), albertaHolidays.get(2).getDate());

		assertEquals("Easter Monday", albertaHolidays.get(3).getName());
		assertEquals(LocalDate.of(2022, 4, 18), albertaHolidays.get(3).getDate());

		assertEquals("Victoria Day", albertaHolidays.get(4).getName());
		assertEquals(LocalDate.of(2022, 5, 23), albertaHolidays.get(4).getDate());

		assertEquals("Canada Day", albertaHolidays.get(5).getName());
		assertEquals(LocalDate.of(2022, 7, 1), albertaHolidays.get(5).getDate());

		assertEquals("Heritage Day", albertaHolidays.get(6).getName());
		assertEquals(LocalDate.of(2022, 8, 1), albertaHolidays.get(6).getDate());

		assertEquals("Labour Day", albertaHolidays.get(7).getName());
		assertEquals(LocalDate.of(2022, 9, 5), albertaHolidays.get(7).getDate());

		assertEquals("State Funeral of Queen Elizabeth II", albertaHolidays.get(8).getName());
		assertEquals(LocalDate.of(2022, 9, 19), albertaHolidays.get(8).getDate());

		assertEquals("National Day for Truth and Reconciliation", albertaHolidays.get(9).getName());
		assertEquals(LocalDate.of(2022, 9, 30), albertaHolidays.get(9).getDate());

		assertEquals("Thanksgiving", albertaHolidays.get(10).getName());
		assertEquals(LocalDate.of(2022, 10, 10), albertaHolidays.get(10).getDate());

		assertEquals("Remembrance Day", albertaHolidays.get(11).getName());
		assertEquals(LocalDate.of(2022, 11, 11), albertaHolidays.get(11).getDate());

		assertEquals("Christmas Day", albertaHolidays.get(12).getName());
		assertEquals(LocalDate.of(2022, 12, 25), albertaHolidays.get(12).getDate());

		assertEquals("St. Stephen's Day", albertaHolidays.get(13).getName());
		assertEquals(LocalDate.of(2022, 12, 26), albertaHolidays.get(13).getDate());
	}

	/**
	 * Tests that the get holidays method works for Quebec in 1999.
	 */
	@Test
	public void getHolidaysWorksForQuebec() {
		HolidayLookup holidayLookup = makeHolidayLookup();

		List<Holiday> quebecHolidays = holidayLookup.getHolidays(1999, Province.Quebec);

		assertEquals(10, quebecHolidays.size());

		assertEquals("New Year's Day", quebecHolidays.get(0).getName());
		assertEquals(LocalDate.of(1999, 1, 1), quebecHolidays.get(0).getDate());

		assertEquals("Good Friday", quebecHolidays.get(1).getName());
		assertEquals(LocalDate.of(1999, 4, 2), quebecHolidays.get(1).getDate());

		assertEquals("National Patriots' Day", quebecHolidays.get(2).getName());
		assertEquals(LocalDate.of(1999, 5, 24), quebecHolidays.get(2).getDate());

		assertEquals("Victoria Day", quebecHolidays.get(3).getName());
		assertEquals(LocalDate.of(1999, 5, 24), quebecHolidays.get(3).getDate());

		assertEquals("National Holiday", quebecHolidays.get(4).getName());
		assertEquals(LocalDate.of(1999, 6, 24), quebecHolidays.get(4).getDate());

		assertEquals("Canada Day", quebecHolidays.get(5).getName());
		assertEquals(LocalDate.of(1999, 7, 1), quebecHolidays.get(5).getDate());

		assertEquals("Labour Day", quebecHolidays.get(6).getName());
		assertEquals(LocalDate.of(1999, 9, 6), quebecHolidays.get(6).getDate());

		assertEquals("National Day for Truth and Reconciliation", quebecHolidays.get(7).getName());
		assertEquals(LocalDate.of(1999, 9, 30), quebecHolidays.get(7).getDate());

		assertEquals("Thanksgiving", quebecHolidays.get(8).getName());
		assertEquals(LocalDate.of(1999, 10, 11), quebecHolidays.get(8).getDate());

		assertEquals("Christmas Day", quebecHolidays.get(9).getName());
		assertEquals(LocalDate.of(1999, 12, 25), quebecHolidays.get(9).getDate());
	}

	/**
	 * Tests that the next holiday method works for September 12.
	 */
	@Test
	public void getNextHolidayWorksForSeptember12() {
		HolidayLookup holidayLookup = makeHolidayLookup();

		Holiday nextHoliday = holidayLookup.getNextHoliday(LocalDate.of(2022, 9, 12), Province.Alberta);

		assertEquals("State Funeral of Queen Elizabeth II", nextHoliday.getName());
		assertEquals(LocalDate.of(2022, 9, 19), nextHoliday.getDate());
	}

}
