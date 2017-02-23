import java.util.ArrayList;

public class DateList {
    private DateNode first;
    private DateNode last;
    private DateNode i;
    private int length;
    
    public DateList() {
        DateNode ln = new DateNode(null);
        first = ln;
        last = ln;
        length = 0;
    }
    
    public void append(Date212 date) {
        DateNode newNode = new DateNode(date);
        last.next = newNode;
        last = newNode;
        length++;
    }
    
    public void insert(Date212 date) {
        DateNode newNode = new DateNode(date);
        if (first.next == null) {
            this.append(date);
            return;
        } //append if linked list is empty.
        
        i = first;
        
        while (i.next != null && i.next.date.compareTo(date) < 0)
            i = i.next; //to look for where to insert node.
        
        if (i.next == null) {
            this.append(date);
            return;
        } else {
            newNode.next = i.next;
            i.next = newNode;
        }
        
        i = first;
        length++;
    }
    
    public ArrayList<String> returnListOfDates() {
        
        //this method is to help setup the GUI:
        ArrayList<String> list = new ArrayList<String>();
        i = first;
        
        while(i.next != null) {
            i = i.next;
            list.add(i.date.toString());
        }
        
        i = first;
        return list;
    }    
}
