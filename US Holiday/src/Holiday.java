import java.time.LocalDate;

/***
 * Includes all of the information about a single instance of a holiday.
 *
 * @author Jason Heard
 */
public class Holiday {

    /**
     * Construct a holiday instance.
     *
     * @param name
     *            The name of the holiday.
     * @param date
     *            The date of the holiday.
     */
    public Holiday(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    private final String name;
    private final LocalDate date;

}
