import java.util.*;   // Importing standard Java libraries, no need of external frameworks like Spring or Hibernate here.   
    
public class java_44579_SessionManager_A03 {                                    
       private List<String> activeUsers;                        
                                                               
        public void createSession(String userName)              
         {  if (activeUsers == null )                             // Initialization   else check whether this session is already logged in or not?     
            activeUsers = new ArrayList<>();                    
         
           activeUsers.add(userName);                          // Add the newly logined users's username to 'Active Users List'.      
         } 
        public void closeSession (String userName)              {                                  
             if (!activeUsers.isEmpty())                         // Check whether we have any session logged in or not?    else return statement  
            activeUsers.remove(userName);                       /* If yes, then remove the specific username from 'Active Users List'. */ 
         }      
        public boolean isLoggedIn (String user)                  {                                  
             if (!activeUsers.isEmpty())                         // Check whether we have any session logged in or not?    else return statement  
            activeUsers.contains(user);                          /* If yes, then check the specific username from 'Active Users List'. */ 
           }     
}                                                                                    };                                      });                           );                             }}                                                                )}};                                  // This is your comment for Java code...