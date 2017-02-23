import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Project2 {
    
    private static boolean isValidDate(String date) {       
        if (date == null || date.isEmpty() || date.length() != 8)
            return false; //return false if date is null, empty, or not 8 chars long.
        
        for (int i = 0; i < date.length(); i++)
            if(!Character.isDigit(date.charAt(i)))
                return false; //return false if any char in date is not a digit.
        
        return true; //return true if no test fails.
    }    

    private static void extractFromFile(String inputFile, DateList linkedList, String action) {
        File file;
        Scanner reader;
        try {
            file = new File(inputFile);
            reader = new Scanner(file);
            
            while (reader.hasNextLine()) {   //to read each line.             
                String line = reader.nextLine();
                StringTokenizer token = new StringTokenizer(line, ",");
                
                while (token.hasMoreTokens()) { //to read each token of every line
                    String date = token.nextToken();
                    Date212 dateObject = null;
                    
                    if (isValidDate(date)) 
                        dateObject = new Date212(date);
                    
                    //following block either inserts or appends new Date212 object to linked list depending on the 'action' argument passed in:
                    if (action.equals("insert") && dateObject != null) 
                        linkedList.insert(dateObject);
                     else if (action.equals("append") && dateObject != null) 
                        linkedList.append(dateObject);                       
                }
            }
        } catch (Exception e) { 
            System.out.println("Error: " + e.getLocalizedMessage());
        }
    }
    
    public static void main(String[] args) {
        DateGUI gui = new DateGUI();
        DateList unsortedLinkedList = new DateList();
        DateList sortedLinkedList = new DateList();

        extractFromFile("project 2/src/date.txt", unsortedLinkedList, "append");
        extractFromFile("project 2/src/date.txt", sortedLinkedList, "insert");
        
        gui.setLeftSide(sortedLinkedList);
        gui.setRightSide(unsortedLinkedList);
        
        gui.run();
    }
    
}
