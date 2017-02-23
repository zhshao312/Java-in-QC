import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileMenuHandler implements ActionListener {

    private DateGUI gui;
    
    public FileMenuHandler(DateGUI gui) {
        this.gui = gui;
    }
    
    public void actionPerformed(ActionEvent event) {
        String menuName = event.getActionCommand();
        
        if (menuName.equals("Open")) 
            openFile();
        else if (menuName.equals("Quit"))
            System.exit(0);
    }
    
    private void openFile() {
        JFileChooser chooser = new JFileChooser();
        int status = chooser.showOpenDialog(null);
        
        if (status == JFileChooser.APPROVE_OPTION)
            readFile(chooser.getSelectedFile());
        else 
            JOptionPane.showMessageDialog(null, "Open File dialog cancelled");
    }
    
    private void readFile(File chosenFile) {
        
        //to read dates from selected file:
        Scanner scan;
        DateList unsorted = new UnsortedDateList();
        DateList sorted = new SortedDateList();
        try {
            scan = new Scanner(chosenFile);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                StringTokenizer token = new StringTokenizer(line, ", ");
                
                while (token.hasMoreTokens()) {
                    Date212 dateObject = new Date212(token.nextToken());
                    System.out.println(dateObject.toString());
                    unsorted.add(dateObject);
                    sorted.add(dateObject);
                }
            } 
        } catch (FileNotFoundException ex) {
            System.out.println("File not found. " + ex.getMessage());
        } catch (NumberFormatException nfe) {
            System.out.println("Date contained non-number chars. " + nfe.getMessage());
        } catch (IllegalDate212Exception e) {
            System.out.println("Illegal date. " + e.getMessage());
        } finally {
            //to put read dates onto the GUI after parsing through the file:
            gui.leftSide.append(unsorted.toString());
            gui.rightSide.append(sorted.toString());
        }  
    }   
 }