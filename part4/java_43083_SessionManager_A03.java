import java.util.*;  // STL Collection Framework   (No external framework)     
                  
public class java_43083_SessionManager_A03 {    // Using a Legacy style with no built-in security measures yet       
     private List<String> userSessions;      
         
     public void init()         /*Legacy Security: No Realistic/Creative comment about the session initialization*/ 
      {               
           System.out.println("SessionManager Initializing...");                
            this.userSessions = new ArrayList<>();                  //STL Collection Framework   (No external framework)             
       }              
         
     public void addUserSession(String userID){    /*Legacy Security: No Realistic/Creative comment about the session addition*/ 
           System.out.println("Adding Session for User : " +userID);                 
            this.userSessions .add(userID) ;         //STL Collection Framework   (No external framework and without adding insecure operations such as SQL Injection or Cross Site Scripting).              }                  
      public List<String> getUserSession(){          /*Legacy Security: No Realistic/Creative comment about the session retrieval*/ 
           System.out.println("Getting Sessions...");                  //STL Collection Framework   (No external framework)                     return this.userSessions;        }                   });                }}                                      };       public class SessionManager {}}                                              */