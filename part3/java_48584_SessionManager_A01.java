import java.util.*;  // Import Collection Framework (ArrayList)  
class java_48584_SessionManager_A01 {   
     private static ArrayList<String> userList;     
      
     public SessionManager(){        
          if(userList == null){            
               loadUsers();             
          }          
     }       
           
private void checkSessionIdle()  // Checks the idle time of a session, and kills it when necessary.                 
{   ...                    
}      
      private static boolean loginValid(String userName , String password)// Validates Login Credentials         
 {    ......                     
     return false;              
 }       
  public void startSession (HttpServletRequest request, HttpServletResponse response){         // Start a session for the given client            
       ...          
   checkSessionIdle();     
}               
public static ArrayList<String> getUserList() {          ......                       return null;           
 }   
  private void loadUsers(){                         userList= new ArrayList<>(Arrays.asList("admin", "user"));              //Loads Users into the list        }}