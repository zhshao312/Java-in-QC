public class SortedDateList extends DateList {
    

    public SortedDateList() {
        DateNode ln = new DateNode(null);
        first = ln;
        last = ln;
        length = 0;
    }
    
    public void add(Date212 date) {
        DateNode newNode = new DateNode(date);
        
        if (first.next == null) {
            last.next = newNode;
            last = newNode;
            length++;
            return;
        }
        
        i = first;
        
        while (i.next != null && i.next.date.compareTo(date) < 0)
            i = i.next;
        
        if (i.next == null) {
            last.next = newNode;
            last = newNode;
        } else {
            newNode.next = i.next;
            i.next = newNode;
        }
        
        i = first;
        length++;
    }
   
}