import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

/***
 * this is a program to find a list of holidays in Canada Provinces or check
 * the. next upcoming holiday
 *
 * @author marab065
 *
 */

public class HolidayFinder {
    /***
     * this is the main function that will run the program and it will ask the user
     * for what he is looking for and then displays the required action and it asks
     * if the user wants to run it again.
     *
     *
     */
    public static void main(String[] args) {

        HolidayLookup holidayFinder = new MyHolidayLookup();
        Holiday holiday;
        List<Holiday> listOfHolidays;
        Scanner keyboard = new Scanner(System.in);
        int choiceEntry = 0;
        int year;

        while (choiceEntry != 3) {
            System.out.println("Welcome to the holiday checker!\n");
            System.out.println("What are you looking for:");
            System.out.println("1 - Find the next holiday?");
            System.out.println("2 - Get a list of holidays?");
            System.out.println("3 - Exit\n");
            System.out.print("Your Selection: ");
            choiceEntry = keyboard.nextInt();

            if (choiceEntry < 1 || choiceEntry > 3) {

                System.out.println("Please try again.");
                choiceEntry = keyboard.nextInt();

            }

            else if (choiceEntry == 1) {

                Province province = getprovince(keyboard);

                if (province == Province.Invalid) {
                    System.out.println("\nSorry Invalid postal abbreviation");

                } else {

                    holiday = holidayFinder.getNextHoliday(LocalDate.now(), province);
                    System.out.print("The next holiday in " + province + " is " + holiday.getName());
                    System.out.print(" on " + holiday.getDate().getMonth());
                    System.out.print(" " + holiday.getDate().getDayOfMonth());
                    System.out.println(",\n" + holiday.getDate().getYear() + ".");

                }

            } else if (choiceEntry == 2) {

                System.out.print("Enter year to retrieve: ");
                year = keyboard.nextInt();

                Province province = getprovince(keyboard);
                listOfHolidays = holidayFinder.getHolidays(year, province);
                if (province == Province.Invalid) {
                    System.out.println("\nSorry Invalid postal abbreviation");

                } else {
                    System.out.println("\nThe " + year + " holidays in " + province + " are:");
                    for (int i = 0; i < listOfHolidays.size(); i++) {
                        System.out.print("- " + listOfHolidays.get(i).getDate().getMonth());
                        System.out.print(" " + listOfHolidays.get(i).getDate().getDayOfMonth());
                        System.out.print(", " + listOfHolidays.get(i).getDate().getYear());
                        System.out.println(": " + listOfHolidays.get(i).getName());
                    }
                }
                choiceEntry = 3;

            } else if (choiceEntry == 3) {
                return;
            }

            System.out.println("\nCheck again?");
            System.out.println("1) Yes, 2) NO.\n");
            choiceEntry = keyboard.nextInt();
            if (choiceEntry == 1) {
                System.out.println();
                choiceEntry = 0;
            } else {
                choiceEntry = 3;
            }

        }
        System.out.println("\nVista la hasta. You'll be back.");

        return;
    }

    private static Province getprovince(Scanner userProvince) {
        System.out.print("Enter province (by postal abbreviation, e.g. AB): ");
        String provinceCode = userProvince.next();
        Province province = Province.getProvinceFromPostal(provinceCode);
        return province;

    }
}
