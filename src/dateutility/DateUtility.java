package dateutility;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Managing and using dates and times, using the new Java Date/Time API ( JDK
 * 8). Fields are provided for choice of units to be returned from date/time
 * difference calculations.
 * <p>
 * @author Gladwin
 * 
 */
public class DateUtility {

    public static void main(String[] args) {

        DateUtility jdk8 = new DateUtility();
        LocalDateTime date = LocalDateTime.now();
        System.out.println(date);
        System.out.println(jdk8.StringToDateTime("1986-04-08 12:30"));
        System.out.println(jdk8.StringToDate("1986-04-08"));
        jdk8.DateFormat();
        String date1 = jdk8.DateFormat();
        System.out.println(date1);
        jdk8.DateTimeFormat();
        String dateTime = jdk8.DateTimeFormat();
        System.out.println(dateTime);
        String dateDifference = jdk8.DifferenceBetweenTwoDates();
        System.out.println(dateDifference);
    }

    /**
     * Return a formatted String representing a date and time.
     * Example:2016-03-30T12:21
     *
     * @param date1 is a String representing date.Example:1986-04-08 12:30
     * @return a dateTime formatted according to LocalDateTime object
     *
     *
     */
    public LocalDateTime StringToDateTime(String date1) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(date1, formatter);
        return dateTime;
    }

    /**
     * Return a formatted String representing a date. Example:2016-03-30
     *
     * @param date1 is a String representing date.Example:1986-04-08
     * @return a date formatted according to LocalDate object
     *
     */
    public LocalDate StringToDate(String date1) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(date1, formatter);
        return date;
    }

    /**
     * The format(DateTimeFormatter) method converts a temporal-based object to
     * a string representation using the specified format. The following code
     * converts an instance of LocalDateTime using the format "MMM d yyyy".
     *
     * @return date1 formatted according to DateTimeFormatter object
     */
    public String DateFormat() {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d yyyy");
        String date1 = date.format(format);
        return date1;
    }

    /**
     * The format(DateTimeFormatter) method is used to get always two digits for
     * the day The following code converts an instance of LocalDateTime using
     * the format "MMM dd yyyy hh:mm a".This pattern includes the hour, minutes,
     * and a.m. and p.m.components.
     *
     * @return dateTime formatted according to DateTimeFormatter object
     */
    public String DateTimeFormat() {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM dd yyyy hh:mm a");
        String dateTime = (date.format(format));
        return dateTime;
    }

    /**
     * This method uses ChronoUnit to know the difference in days/months/years
     * and to know the difference in smaller time units e.g. milliseconds,
     * minutes etc.
     *
     * @return dateDifference in
     * nanoseconds,seconds,milliseconds,minutes,hours,days,months,years.
     */
    public String DifferenceBetweenTwoDates() {
        LocalDateTime dateTime = LocalDateTime.of(1988, 7, 4, 0, 0);
        LocalDateTime dateTime2 = LocalDateTime.now();
        long Nano = ChronoUnit.NANOS.between(dateTime, dateTime2);
        long Seconds = ChronoUnit.SECONDS.between(dateTime, dateTime2);
        long Milli = ChronoUnit.MILLIS.between(dateTime, dateTime2);
        long Minutes = ChronoUnit.MINUTES.between(dateTime, dateTime2);
        long Hours = ChronoUnit.HOURS.between(dateTime, dateTime2);
        long Days = ChronoUnit.DAYS.between(dateTime, dateTime2);
        long Months = ChronoUnit.MONTHS.between(dateTime, dateTime2);
        long Years = ChronoUnit.YEARS.between(dateTime, dateTime2);
        String dateDifference = "Nano: " + Nano + ", Seconds: " + Seconds
                + ",Milli :" + Milli + ",Minutes:" + Minutes + " ,Hours:" + Hours
                + ",Days:" + Days + ",Months:" + Months + ",Years" + Years;
        return dateDifference;

    }
}
