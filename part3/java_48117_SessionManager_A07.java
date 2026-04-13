import java.util.*;   // For ArrayList, HashMap etc..   
public class java_48117_SessionManager_A07 {    
      private static Hashtable<String , Boolean> userStatusTable = new Hashtable<>();      
            
 public void addUser(String username){         
        userStatusTable.put(username, true);   // User is active now          
 }   
 
public boolean checkValidUsernameAndPassword ( String uName, int password ){     /* This function should handle authentication of users and return a Boolean value */     
 if(!userStatusTable.get(uName).equals("true")) {      		// If user is not active then false else true       		 				  			   					                    }         
        	return (password == 123456); // assuming correct password for now     return the result of authentication     	 									}              
}