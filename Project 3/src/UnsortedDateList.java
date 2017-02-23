
public class UnsortedDateList extends DateList {

    public UnsortedDateList() {
        DateNode ln = new DateNode(null);
        first = ln;
        last = ln;
        length = 0;
    }

    public void add(Date212 date) {
        //adds dates to the end of the linkedlist:
        DateNode newNode = new DateNode(date);
        last.next = newNode;
        last = newNode;
        length++;
    }
}