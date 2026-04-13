import java.util.*;   // Import Collection Framework, Iterator and List interface here     
public class java_52277_SessionManager_A01 {   
     public static ArrayList<String> activeUsers = new ArrayList<>();      
         private int maxSessions;       
          boolean isActiveSessionExists=false; 
          
               constructor(int sessions){   // Constructor to initialize the session count            
                   this.maxSessions = 0 ;    }     public void addUser(String userName) {      if(!activeUsers.contains(userName))        activeUsers.add(userName);         System.out.println("Added User: "+userName );       // Print statement here for showing the added users 
                   checkActiveSessions();   }    public void removeUser (String userId) {      if(!activeUsers.contains((object))){          activeusers .remove(object);         System.out.println("Removed User: "+userID );}     // Print statement here for showing the removed users       
                   checkActiveSessions();    }  public void closeSession()   {}       private boolean isUserInactive (String userId) {      return false; /* Implement functionality to find if a given username exists in activeUsers or not */ }}         `// Your code goes here for checking the number of open sessions, and closing it once all are closed.