import java.util.TreeMap;

public class SortedDateList extends DateList {
    
	private TreeMap<Date212, String> map;

    public SortedDateList(Date212Comparator date212Comparator) {
        //this comparator will order keys by dates:
        map = new TreeMap(date212Comparator);
    }

    @Override
    public void add(Date212 date) {
        map.put(date, date.toString());
    }

    public String toString() {
        String listOfDates = "";

        //key set in ascending order:
        for (Date212 key : map.keySet()) 
            listOfDates += key.toString() + "\n";

        return listOfDates;
    }
}