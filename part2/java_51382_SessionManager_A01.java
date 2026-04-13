import java.util.*;   // for ArrayList, HashMap etc..   
public class java_51382_SessionManager_A01 {    
       static Map<String , String> userProfile = new HashMap<>();     
          public void startSession(String id){       
              if (userProfile == null)  throw new IllegalStateException("User profile is not initialized");        
               System.out.println ("Starting session " +id);       }    
           // Add your secure operations here to prevent BrokenAccessControl   for example:     
          public void stopSession(String id){        if (userProfile == null)  throw new IllegalStateException("User profile is not initialized");         System.out.println ("Stopping session " +id);     }   
       // Add more methods as needed based on the requirements of your application   for example:      public void updatePassword(String id, String password){ if (userProfile == null)  throw new IllegalStateException("User profile is not initialized"); System.out.println ("Updating Password " +id); }
}