import javax.swing.*;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

public class DateGUI {

    private JFrame frame;
    private JTextArea leftSide;
    private JTextArea rightSide;

    public void run() {
        frame = new JFrame("Project2");
        frame.setPreferredSize(new Dimension(240, 300));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        putTogether(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);        
    }
    
    public void setLeftSide(DateList linkedList) {
             
        String dates = "Sorted dates: " + "\n";
        ArrayList<String> list = linkedList.returnListOfDates();
        
        for (String date : list) 
            dates += date + "\n";
        
        
        leftSide = new JTextArea(dates);
        leftSide.setEditable(false);
    }
    
    public void setRightSide(DateList linkedList) {
        String dates = "Unsorted dates: " + "\n";
        ArrayList<String> list = linkedList.returnListOfDates();
        
        for (String date : list)
            dates += date + "\n";
        
        rightSide = new JTextArea(dates);
        rightSide.setEditable(false);
    }
    
    private void putTogether(Container container) {
        GridLayout layout = new GridLayout(1, 2);
        container.setLayout(layout);
        
        container.add(leftSide);
        container.add(rightSide);
    }
}