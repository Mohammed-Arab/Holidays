import java.time.LocalDate;
import java.util.List;

/**
 * Defines an interface for retrieving holidays in Canada.
 *
 * @author Jason Heard
 */
public interface HolidayLookup {

    /**
     * Retrieves the holidays in Canada for the given year and province.
     *
     * @param year
     *            The year to retrieve.
     * @param province
     *            The province to limit the holidays to.
     * @return A collection of holidays for the given year and province.
     */
    public List<Holiday> getHolidays(int year, Province province);

    /**
     * Retrieves the next holiday on or after the given date. If there is a
     * holiday on the given date, that should be returned.
     *
     * Note that this may return a holiday in the following year.
     *
     * @param date
     *            The date to use for the holiday search.
     * @return The next holiday on or after the given date.
     */
    public Holiday getNextHoliday(LocalDate date, Province province);

}
