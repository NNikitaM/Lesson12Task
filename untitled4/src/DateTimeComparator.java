import java.util.Comparator;

public class DateTimeComparator implements Comparator<DateTime> {

    @Override
    public int compare(DateTime dt1, DateTime dt2) {
        return Integer.compare((dt1.day + dt1.month + dt1.year + dt1.hours + dt1.minutes + dt1.seconds),
        (dt2.day + dt2.month + dt2.year + dt2.hours + dt2.minutes + dt2.seconds));
    }
}