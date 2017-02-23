public abstract class DateList {
    
    protected DateNode first;
    protected DateNode last;
    protected DateNode i;
    protected int length;

    public abstract void add(Date212 date);

    public String toString() {
        String date = "";
        i = first.next;

        while (i != null) {
        	date += i.date.toString() + "\n";
            i = i.next;
        }

        return date;
    }
}