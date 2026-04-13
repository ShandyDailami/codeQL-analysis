public class java_48127_SessionManager_A08 {
    private String value;   // store a plain text string, used for example only during verification purpose    
                            
                              
    public void setValue(String s) throws Exception{// this is where we put our checksum (a hash or something similar), you can use any method to calculate it     
        if (!s.matches("^[A-F0-9]{32}$")) { // check whether the string length and contents are valid in hexadecimal format        
            throw new Exception ("Invalid data, not exactly 32 characters long.");            
       }          
              value = s;    
    }         
      public String getValue() throws IllegalAccessException{   /* this method is for other classes to call when they want the checksum */       
         if (value == null) {// in case we have not yet set a data, let's throw an exception      
             throw new IllegalAccessException ("Not initialized.");      }              return value;    }}  // end of DataChecksums class  
public interface SessionManager{     /* this is our session manager */          public void startSession(String userID) throws Exception {...}        ...         };                            ......       private String currentUser = null ;            if (userId.equals("admin"))      throw new A08_IntegrityFailure ("Access Denied");