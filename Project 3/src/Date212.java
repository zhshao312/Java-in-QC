public class Date212{

    private int year;
    private int month;
    private int day;

    public Date212(int year, int month, int day) {      
        if (year < 0 || month > 12 || day > 31)
            throw new IllegalDate212Exception("Illegal date");
        this.year = year;
        this.month = month;
        this.day = day;
    }

	public Date212(String d){

	    year = Integer.parseInt(d.substring(0,4));
	    month = Integer.parseInt(d.substring(4,6));
		day = Integer.parseInt(d.substring(6,8));
		
	}

	@SuppressWarnings("static-access")
	public int compareTo(Date212 other) {
        int value = 0;
        if (this.year == other.year) {
        	
        	if (this.month == other.month)
 
        	{   
        		if (this.day == other.day) 
                      			
        		   value = 0;
                 
        		else if (this.day < other.day)
        			value = -1;  
        		else if (this.day > other.day)
        			value = 1;
        	}        		
        		
                else if (this.month < other.month)
                	value = -1;  
            		
                else if (this.month > other.month)
                	value = 1; 
            }    	 
       
        else if (this.year < other.year)
        	value = -1;  
  		
      
        else if (this.year > other.year)
        	value = 1;
		       
        
    
        return value;
	}

	
	public int getYear(){
		
		return year;
		
	}
	
	public String toString( ){
	      
	      String cmonth = "";
	      String cday = "";
	      
	      if(day<10){
	         cday ="0" + Integer.toString(day);
	      }
	      else{
	         cday = Integer.toString(day);
	      }
	   
	      if(month<10){
	         cmonth = "0" + Integer.toString(month);
	      }
	      else{
	         cmonth = Integer.toString(month);
	      }
	   
	   
	      return  cmonth + "/" + cday + "/" +  Integer.toString(year);
	   
	   
	   }
}
