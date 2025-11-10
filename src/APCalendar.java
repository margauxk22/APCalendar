public class APCalendar {

    //returns true if leap year and false if not leap year
    private static boolean isLeapYear(int year) {
        return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
    }

    // number of leap years between 1 and 2
    public static int numberOfLeapYears(int year1, int year2) {
        int num = 0;
        for(int i = 0; i <= (year2 - year1); i++) {
            if (isLeapYear(year1 + i)) num++;
        }
        //return


        return num;
    }

    // 0 is sunday,/ 1 is monday, 6 is saturday



    private static int firstDayOfYear(int year) {
        int x = Math.abs(year - 1899);

        for (int i = 1900; i < year; i++) if (isLeapYear(i)) x++;
        return (x % 7);
    }

    // 1 = month, 1 = day. Dec 12 = 12 12-
    private static int dayOfYear(int month, int day, int year) {
        int count = 0;
        for(int i = 1; i < month; i++) {

            if (i == 1 || i == 3 || i == 5 ||   i == 7 || i == 8   || i == 10) count += 31;
            else if ((i == 2) && (isLeapYear(year))) count += 29;
            // call is leap year
            else if ((i == 2) && !(isLeapYear(year))) count += 28;
            else count += 30;
        }



        return count += day;
    }


    public static int dayOfWeek(int month, int day, int year) {
        return (firstDayOfYear(year) + dayOfYear(month, day, year) - 1) % 7;
    }

}