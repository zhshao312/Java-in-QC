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
        
        //menu option can either open+read file or quit program:
        if (menuName.equals("Open")) 
            openFile();
        else if (menuName.equals("Quit")) 
            System.exit(0);
    }
    
    private void openFile() {
        JFileChooser chooser = new JFileChooser();
        int status = chooser.showOpenDialog(null);
        
        if (status == JFileChooser.APPROVE_OPTION)
            readSource(chooser.getSelectedFile());
        else 
            JOptionPane.showMessageDialog(null, "Open File dialog cancelled");
    }
    
    private void readSource(File chosenFile) {
        //read file
        Scanner reader;
        DateList unsorted = new UnsortedDateList();
        DateList sorted = new SortedDateList(new Date212Comparator());
        try {
            reader = new Scanner(chosenFile);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                StringTokenizer token = new StringTokenizer(line, ", ");
                
                while (token.hasMoreTokens()) {
                    Date212 dateObject = new Date212(token.nextToken()); //attempt to create new Date212 object
                    unsorted.add(dateObject);
                    sorted.add(dateObject);
                }
            } 
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe);
        } catch (NumberFormatException nfe) {
            System.out.println(nfe);
        } catch (IllegalDate212Exception ide) {
            System.out.println(ide);
        } finally {

        	gui.leftSide.append(unsorted.toString());
            gui.rightSide.append(sorted.toString());
        }  
    }   
 }
