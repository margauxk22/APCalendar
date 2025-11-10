import java.sql.SQLOutput;


// test cases/
public class Main {
    public static void main(String[] args){
        System.out.println(APCalendar.numberOfLeapYears(2020,2028));
        System.out.println(APCalendar.dayOfWeek(1, 5, 2019));
        System.out.println(APCalendar.dayOfWeek(1, 10, 2019));
        System.out.println(APCalendar.dayOfWeek(10, 30, 2025));
    }
}