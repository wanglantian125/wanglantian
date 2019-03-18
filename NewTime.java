import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class NewTime {
    public static void main(String[] args) {
        /*LocalDate date = LocalDate.now();
        int year = date.get(ChronoField.YEAR);
        System.out.println(year);*/
        Instant now = Instant.now();
        /*LocalDate date = LocalDate.now();
        int days=date.getDayOfMonth();
        LocalDate localDate = date.withDayOfMonth(days-1);*/
        Instant plus = now.plus(-1, ChronoUnit.DAYS);
        LocalDateTime now1 = LocalDateTime.now();
        LocalDateTime plus1 = now1.plus(-1, ChronoUnit.DAYS);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = plus1.format(dtf);

        System.out.println(format);

        /*Instant time=Instant.now();
        int days = date.lengthOfMonth();
        System.out.println("该日期为"+date.toString()+"时分秒为"+time.toString()+"该月有多少"+days+"天");*/
    }
}
