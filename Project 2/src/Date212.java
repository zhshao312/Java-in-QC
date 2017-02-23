public class Date212 {

    private int year;
    private int month;
    private int day;

    public Date212(int year, int month, int day) {

        this.year = year;
        this.month = month;
        this.day = day;
    }

    public Date212(String date) {
        
        //this will call the 3-argument constructor:
        this(Integer.parseInt(date.substring(0, 4)),
                Integer.parseInt(date.substring(4, 6)),
                Integer.parseInt(date.substring(6)));
    }

    public int compareTo(Date212 other) {
        
        //to compare the year, month, and date of the two Date212 objects:
        if (this.year == other.year) 
            if (this.month == other.month) 
                if (this.day == other.day) 
                    return 0;
                 else 
                    return this.day - other.day;         
            else 
                return this.month - other.month;   
        else 
            return this.year - other.year;        
    }

    @Override
    public String toString() {
        String date = "";
        
        //the following if/elif/else blocks are to return dates in yyyy/mm/dd format:
        
        if (year < 10) 
            date += "000" + Integer.toString(year) + "/";
        else if (year < 100)
            date += "00" + Integer.toString(year) + "/";
        else if ( year < 1000)
            date += "0" + Integer.toString(year) + "/";
        else 
            date += Integer.toString(year) + "/";
        
        
        if (month < 10)
            date += "0" + Integer.toString(month) + "/";
        else 
            date += Integer.toString(month) + "/";
        
        
        if (day < 10)
            date += "0" + Integer.toString(day);
        else 
            date += Integer.toString(day);
        
        
        return date;
    }
}
