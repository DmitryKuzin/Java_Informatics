import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

/**
 * @author Gataullin Kamil
 *         15.02.2015 19:07
 */
public class APIDate {

    public static ZoneId zone1;
    public static ZoneId zone2;

    public static void main(String arg[]) {
        clock();
        zone();
        localTime();
        localDate();
        localDateTime();
    }

    public static void clock() {
//        Тип Clock предоставляет доступ к текущей дате и времени. Этот тип знает о часовых поясах и
//        может использоваться вместо вызова System.currentTimeMillis() для возвращения миллисекунд.
        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();

        Instant instant = clock.instant();
        Date legacyDate = Date.from(instant);   // legacy java.util.Date
    }

    public static void zone() {
//        Часовые пояса представлены типом ZoneId.
//        Часовые пояса содержат смещения, которые важны для конвертации дат и времени в местные.
        System.out.println(ZoneId.getAvailableZoneIds());

        zone1 = ZoneId.of("Europe/Berlin");
        zone2 = ZoneId.of("Brazil/East");
        System.out.println(zone1.getRules());
        System.out.println(zone2.getRules());
    }

    public static void localTime() {
//        Тип LocalTime представляет собой время с учетом часового пояса, например, 10pm или 17:30:15.
        LocalTime now1 = LocalTime.now(zone1);
        LocalTime now2 = LocalTime.now(zone2);

        System.out.println(now1.isBefore(now2));  // false

        long hoursBetween = ChronoUnit.HOURS.between(now2, now1);
        long minutesBetween = ChronoUnit.MINUTES.between(now2, now1);

        System.out.println(hoursBetween);
        System.out.println(minutesBetween);

        LocalTime late = LocalTime.of(23, 59, 59);
        System.out.println(late);       // 23:59:59

        DateTimeFormatter germanFormatter = DateTimeFormatter
                        .ofLocalizedTime(FormatStyle.SHORT)
                        .withLocale(Locale.GERMAN);

        LocalTime leetTime = LocalTime.parse("13:37", germanFormatter);
        System.out.println(leetTime);   // 13:37
    }

    public static void localDate() {
//        Тип LocalDate представляет конкретную дату, например, 2014-03-11.
//        Объекты LocalDate неизменяемы и являются аналогом LocalTime.
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
        LocalDate yesterday = tomorrow.minusDays(2);

        LocalDate independenceDay = LocalDate.of(2014, Month.JULY, 4);
        DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
        System.out.println(dayOfWeek);    // FRIDAY

        DateTimeFormatter germanFormatter = DateTimeFormatter
                        .ofLocalizedDate(FormatStyle.MEDIUM)
                        .withLocale(Locale.GERMAN);

        LocalDate xmas = LocalDate.parse("24.12.2014", germanFormatter);
        System.out.println(xmas);   // 2014-12-24
    }

    public static void localDateTime() {
//        Тип LocalDateTime представляет собой комбинацию даты и времени.
//        Объекты LocalDateTime неизменяемы и работают аналогично LocalTime и LocalDate.
        LocalDateTime sylvester = LocalDateTime.of(2014, Month.DECEMBER, 31, 23, 59, 59);

        DayOfWeek dayOfWeek = sylvester.getDayOfWeek();
        System.out.println(dayOfWeek);      // WEDNESDAY

        Month month = sylvester.getMonth();
        System.out.println(month);          // DECEMBER

        long minuteOfDay = sylvester.getLong(ChronoField.MINUTE_OF_DAY);
        System.out.println(minuteOfDay);    // 1439

        Instant instant = sylvester.atZone(ZoneId.systemDefault()).toInstant();
        Date legacyDate = Date.from(instant);
        System.out.println(legacyDate);

        DateTimeFormatter formatter =DateTimeFormatter.ofPattern("MM dd, yyyy - HH:mm");

        LocalDateTime parsed = LocalDateTime.parse("10 03, 2014 - 07:13", formatter);
        String string = formatter.format(parsed);
        System.out.println(string);
//        DateTimeFormatter является неизменяемым и потокобезопасным
    }
}
