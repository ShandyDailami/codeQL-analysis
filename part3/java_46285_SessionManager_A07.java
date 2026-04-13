import java.util.*;   // for List, ArrayList etc..   
public class java_46285_SessionManager_A07 {     // begin of session manager Class        
// Declare a list to keep track if user is logged in         
private static List<String> loggedUsers = new ArrayList<>();     
       public void startSession(String username)  throws Exception{        try   {           
           System.out.println("Starting Session for User: " +username);         // Logic to setup session, check if user is already log in...          }             catch (Exception e){              throw new RuntimeException ("Failed starting a sessions",e );}       }      public void endSession(String username)  throws Exception{        try   {           
           System.out.println("Ending Session for User: " +username);         // Logic to cleanup session...          }             catch (Exception e){              throw new RuntimeException ("Failed ending a sessions",e );}       }     public static boolean isUserLoggedIn(String username) {       
           return loggedUsers.contains(username);      System.out.println("Checking the user: " + username+" Is Loged In : ?"  +isUserLoggedIn ());             if (!loggedUsers.contains(username)){            throw new Exception ("Username not found in Session Manager");        }       return true;   }} // end of session manager Class