public class APCalendar {

    /** Returns true if year is a leap year and false otherwise. */
    private static boolean isLeapYear(int year) {
        return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
    }

    /** Returns the number of leap years between year1 and year2, inclusive.
     * Precondition: 0 <= year1 <= year2
     */
    public static int numberOfLeapYears(int year1, int year2) {
        int num = 0;
        for(int i = 0; i <= (year2 - year1); i++) {
            if (isLeapYear(year1 + i)) num++;
        }
        return num;
    }

    /** Returns the value representing the day of the week for the first day of year,
     * where 0 denotes Sunday, 1 denotes Monday, ..., and 6 denotes Saturday.
     */
    private static int firstDayOfYear(int year) {
        int x = Math.abs(year - 1899);
        for (int i = 1900; i < year; i++) if (isLeapYear(i)) x++;
        return (x % 7);
    }

    /** Returns n, where month, day, and year specify the nth day of the year.
     * Returns 1 for January 1 (month = 1, day = 1) of any year.
     * Precondition: The date represented by month, day, year is a valid date.
     */
    private static int dayOfYear(int month, int day, int year) {
        int count = 0;
        for(int i = 1; i < month; i++) {
            if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10) count += 31;
            else if ((i == 2) && (isLeapYear(year))) count += 29;
            else if ((i == 2) && !(isLeapYear(year))) count += 28;
            else count += 30;
        }
        return count += day;
    }


    public static int dayOfWeek(int month, int day, int year) {
        return (firstDayOfYear(year) + dayOfYear(month, day, year) - 1) % 7;
    }

}