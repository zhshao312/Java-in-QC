import javax.swing.*;
import java.awt.GridLayout;

public class DateGUI extends JFrame {
    public JTextArea leftSide;
    public JTextArea rightSide;
    
    public DateGUI() {
        setTitle("Project4");
        setSize(400, 450);
        setLocation(500, 250);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        leftSide = new JTextArea("Unsorted dates: " + "\n");
        rightSide = new JTextArea("Sorted dates: " + "\n");
        getContentPane().setLayout(new GridLayout(1, 2));
        getContentPane().add(leftSide);
        getContentPane().add(rightSide);
        fileMenu();
        setVisible(true);
    }

    private void fileMenu() {
        JMenu fileMenu = new JMenu("File"); 
        JMenuBar menuBar = new JMenuBar();
        JMenuItem item = new JMenuItem("Open"); 
        FileMenuHandler fmh = new FileMenuHandler(this);
        item.addActionListener(fmh);
        fileMenu.add(item);

        item = new JMenuItem("Quit"); 
        item.addActionListener(fmh);
        fileMenu.add(item);
        setJMenuBar(menuBar);
        menuBar.add(fileMenu);
    }
   
    public static void main(String[] args) {
        DateGUI gui = new DateGUI();
    }
}
