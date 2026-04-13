import java.util.*;  // Importing all necessary classes from collection framework in order to use ArrayList, HashMap etc...
public class java_52784_SessionManager_A01 {    // Start of our session manager implementation
     private static int count = 0;   // Initialize a counter variable for each new instance created by this object (to generate unique IDs) 
     
     public String id = "";           // A string identifier that will be used to identify the sessions. It'll automatically get set with every session creation in our SessionManager class: it gets incremented on construction and should remain constant across instances of an implementing subclass or instance variable, not shared among objects (unless you make sure this is thread safe)
     
     private Date created;              // This will hold the timestamp when a new user has been added to your system. It's used by our SessionManager class as it records session creation time 
   
     public HashMap<String, Object> data = null ;        // A place holder for storing any kind of object you want in this session (it can be anything). This is how we will store user related information that has been set during the life span. So if a new User login was successful then all these info get stored here
     
     public java_52784_SessionManager_A01() { 
         //Every time an instance created, increment count and use it as ID...  
         ++count;   
        this.id = "S" + String.valueOf(count);           
      	created= new Date();                            //Set the session creation date to current system's timestamp (current_date).... 		    	   
      }        
}//End of SessionManager Class...	 			  	       				   						//END OF CODE SNIPPETS!         	}                                                    public static void main(String[] args){                  //Starting point to test our session manager                   ArrayList<SessionManager> sessions = new 			ArrayList<>();            for (int i=0;i <5 ; ++i)             {                SessionManager sm  =new  			   						//CREATING NEW SESSIONS HERE              }          System.out .println(sessions);