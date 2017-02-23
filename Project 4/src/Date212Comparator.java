import java.util.Comparator;

public class Date212Comparator implements Comparator <Date212> {

    //used in SortedDateList class to sorts by dates:
    @Override
    public int compare(Date212 date1, Date212 date2) {
        return date1.compareTo(date2);
    }
}
