import java.util.TreeMap;

public class UnsortedDateList extends DateList {
    private TreeMap<Integer, Date212> map;
    private int length; 
    
    public UnsortedDateList() {
       map = new TreeMap();
       length = 0;
    }
    
    @Override
    public void add(Date212 date) {
        //add Date212 object
        map.put(length, date);
        length++; 
    }
    
    public String toString() {
        String datesString = "";

        //iterate key set and return key's value toString()
        for (Integer key : map.keySet()) 
            datesString += map.get(key).toString() + "\n";
        

        return datesString;
    }    

}
