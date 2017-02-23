/**
  *  CS212 11G
  *  Zihao Shao
  *  project 1
  **/
  
import java.applet.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class Project1 extends Applet{
   
   String s1 = "", s2 = "";
   //init method
   //create frame named DateGUI, set the layout of GridLayout and size of 400, 400
   //add two new textArea on the frame  
   public void init(){
    
      setLayout(new GridLayout(1,1));
      setSize(400,400);
      Frame title = (Frame)this.getParent().getParent();
      title.setTitle("DateGUI");
      //go read method
      try { 
      
         read();
      
      }
      catch(Exception e){
          
      }
      
      add(new TextArea(s1));
      add(new TextArea(s2));
   }
   
   //check method
   public boolean check(String s){
     
      String base = "0123456789";  
      boolean str = true;
      
      for (int i = 0; i < s.length(); i++){
         
         if(base.indexOf( s.charAt(i) )!=-1){
            
            str = true;
            
            } else {
            
            str = false;
            
            }
      }
      return str;
   }
   
   //sort method  
   //sort the date in sorted order
   public int[] sort(int[] a){
      int t,k;
      for (int i = 0; i < a.length; i++){        
         k=i;         
         for (int j = i+1; j < a.length; j++)
            if(a[k]>a[j]){ 
               k=j;
            }     
         t=a[i]; 
         a[i]=a[k]; 
         a[k]=t;
      }

      return a;
   }

   //read method
   public void read() throws Exception{
      //create a arraylist to collect elements from txt file
      ArrayList<Integer> list = new ArrayList<Integer>();
      String temp;
      //create new file from date.txt, and use scanner to read it
      File file = new File("date.txt");
      Scanner scan = new Scanner(file);
      
      int num[];
      
      while(scan.hasNext()){
       
         String t;
                  
         temp = scan.next() ;        
         //use StringTokenizer to seperate string of ",\n"
         StringTokenizer st = new StringTokenizer(temp,",\n");
         
         while(st.hasMoreTokens())
            //if past check method return ture, date number = s1 and add number into arraylist
            if(check(t = st.nextToken())){
               
               s1 = s1+t+"\n";
               
               list.add(new Integer(t));
            }
            else {
            
               System.out.println(t);
            
            }//else print the string
      }
      
      num = new int[list.size()];     
      for (int i = 0; i < list.size(); i++){
        
         num[i] = (int)list.get(i);
      
      }
      //sort the number
      num = sort(num);
      for (int i = 0; i < num.length; i++){ 
        
         s2 = s2+num[i]+"\n";
      
      }
      scan.close();
   }

}