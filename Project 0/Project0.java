/**
  *  CS212 11G
  *  Zihao Shao
  *  project 0
  **/

import javax.swing.*;

public class Project0{
   //main method
   public static void main(String[] args){
   
      //create a new JFrame named input
      JFrame frame = new JFrame("Input");
      String input = "";
   
      //use while loop to loop the program when user using.
      while(true){       
         //create two counters to count how many e's and E's in input String and set default is 0
         int counter1 = 0;
         int counter2 = 0;
         //create two checks of e and E
         char check1 = 'e';
         char check2 = 'E';
      
         try{
            //collect the input from user on JoptionPane 
            input = JOptionPane.showInputDialog(frame, "Please enter a sentece");
            //for loop to count how many e's in input string
            for (int i = 0; i < input.length(); i++) {
               if (input.charAt(i) == check1) {
                  counter1++;
               }
            }
            //for loop to count how many E's in input string
            for (int i = 0; i < input.length(); i++) {
               if (input.charAt(i) == check2) {
                  counter2++;
               }
            } 
            //create a new JFrame named message             
            JFrame frame2 = new JFrame("Message");
            //print the count results of e and E on the JOptionPane
            JOptionPane.showMessageDialog(frame2,
               "Number of lower case e's: " + counter1 + "\n" + "Number of lower case e's: " + counter2);
            //set a condition that when user type "stop", end the program
            if(input.equalsIgnoreCase("stop")){
            
               System.exit(0);
            
            }
            
            
         }
         
         catch(NullPointerException e){
            System.exit(0);
         }
      }
   
   } 
}



