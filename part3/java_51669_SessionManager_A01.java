import java.util.*;  // for ArrayList and HashMap (Optional)   
    
public class java_51669_SessionManager_A01 {  
        
private static Hashtable<String , String> userCredentialsTable = new Hashtable<>();       
     
static{         
userCredentialsTable.put("admin", "password");  // Add your users in this table if you have some    
}             
      
public void validateUser(String userName, String password){  
        
if(!userCredentialsTable.containsKey(userName)){   
System.out.println("Invalid User.");      return; }              
           
  // Here we are assuming that the entered passWord matches with our stored one:     If not then throw exception or handle it as per requirement       if (!password.equals( userCredentialsTable.get(userName))) {   System.out.println("Invalid Password"); return; }    else{
System.out.println("User has logged in successfully.");  // Just for showing that we are able to track session of the users      }}          public void closeSession (String userName){         if(!sessionTable.containsKey(userName)){            System.out.println ("No active sessions found with this name"); return;}        else {            
// Here you can add logic related open and closing a database connection, file operations etc for the session    }}      }  //end of SessionManager implementation}};     If not then throw exception or handle it as per requirement       if(!sessionTable.containsKey(userName))            System.out.println("No active sessions found with this name"); return;}        else {            
// Here you can add logic related open and closing a database connection, file operations etc for the session    }}  //end of SessionManager implementation}};     If not then throw exception or handle it as per requirement      }   catch (Exception ex) {}       System.out.println("An error has occurred: " +ex );