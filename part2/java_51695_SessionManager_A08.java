import java.util.*; // For ArrayList, HashMap... etc.  
public class java_51695_SessionManager_A08 {    
    private static Map<String, String> sessionDB = new HashMap<>();     
      
    public void startSecuritySession(String userName){         
        System.out.println("Starting security session for " + userName);             
           //Here we could do some setup such as setting a cookie...        
     }               
              
   /* We use static methods to prevent instantiation of the class and encapsulate related functionality */      
      public static void saveSessionData(String key, String value) {   
          if (value == null || "".equalsIgnoreCase(value.trim())){        //Checking for integrity failure when saving a session data  
              System.out.println("The saved Session: UserName=" +key+ ", Data = Null");            
          } else  {                 
               String oldValue =  sessionDB.get(key);                     
	       if (oldValue != null && oldValue.equalsIgnoreCase(value)){        //Checking for integrity failure when saving a new data           
			   System.out.println("New Data saved: UserName = " + key+ ", PreviousData =  "  + oldValue +  "; Newdata=  "   +  value);             
		       } else {                   
				  sessionDB.put(key,value );                            //Saving data in the Session Map               	  
			      System.out.println("New Data saved: UserName =" + key+ ", SavedData =  "  + value);                 	   
           	}             		      					   							     }            				  public static void main(String[] args){} });          //Here we call the start function to test our session manager      SecuritySessionManager.startSecuritySession("John Doe");         SessionDB contains {"UserName1":"Data", "UserName2": Data};