import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/***
 * this implements the HolidayLookup interface class.
 *
 * @author ma7am
 *
 */
public class MyHolidayLookup implements HolidayLookup {

    @Override
    public List<Holiday> getHolidays(int year, Province province) {
        final String url = String.format("https://date.nager.at/api/v2/publicholidays/%d/US", year);
        // this is to get the list from the url with the year that is provided by the
        // user.
        Gson gson = new Gson();
        try (Reader jsonReader = new InputStreamReader(new URL(url).openStream())) {
            Type listType = new TypeToken<List<NagerHoliday>>() {
            }.getType();
            List<NagerHoliday> nagerHolidays = gson.fromJson(jsonReader, listType);
            // this is a list of holidays that was imported from the url
            // with the NagerHoliday variables name,date,global and counties
            List<Holiday> holidays = new ArrayList<Holiday>();

            for (NagerHoliday tempNagerHolidays : nagerHolidays) {
                if (tempNagerHolidays.global == false) {
                    for (String county : tempNagerHolidays.counties) {
                        if (county.equals("CA-" + province.getCode())) {
                            holidays.add(new Holiday(tempNagerHolidays.name, LocalDate.parse(tempNagerHolidays.date)));
                        }
                    }
                } else {
                    holidays.add(new Holiday(tempNagerHolidays.name, LocalDate.parse(tempNagerHolidays.date)));
                }
            }
            // this loop is to check for every holiday in the list and then add
            // the one's that satisfies with the user requirement.

            return holidays;
        }

        catch (IOException ex) {
            // handle errors downloading the file...
        }

        return null;
    }

    @Override
    public Holiday getNextHoliday(LocalDate date, Province province) {
        /**
         * this function is to call getholidays and then checks for the next upcoming
         * holiday using current date and then returns the holiday that is closest to
         * the current date.
         */
        List<Holiday> holidays = new ArrayList<Holiday>();
        Holiday holiday = null;
        holidays = getHolidays(date.getYear(), province);

        for (int i = 0; i < holidays.size(); i++) {

            if (holidays.get(i).getDate().getMonthValue() > date.getMonthValue()) {

                holiday = holidays.get(i);
                i = holidays.size();
            } else if (holidays.get(i).getDate().getMonthValue() == date.getMonthValue()
                    && holidays.get(i).getDate().getDayOfMonth() >= date.getDayOfMonth()) {

                holiday = holidays.get(i);
                i = holidays.size();
                ;
            } else if (holidays.get(i).getDate().getMonthValue() == 12
                    && holidays.get(i).getDate().getDayOfMonth() <= date.getDayOfMonth()) {

                holidays = getHolidays((LocalDate.now().getYear() + 1), province);
                i = 0;
                holiday = holidays.get(i);
                i = holidays.size();
            }

        }
        return holiday;
    }

    private static class NagerHoliday {
        String date;
        String name;
        boolean global;
        String[] counties;
    }
}