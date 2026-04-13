import java.util.*;  // Import ArrayList, HashMap and UserDetails interfaces  
public class java_51829_SessionManager_A07 {   
     private Map<String, Object> sessionStore;     
       public void createSession(Object obj){          this.sessionStore = new HashMap<>();         }          
        @SuppressWarnings("unchecked")             // Supress warning in case of incorrect types           
public  UserDetails getUserFromSessionId (String id) {                   if(!this.sessionStore.containsKey(id)){                 return null;          }}                       else{                     System.out.println ("Returning session: "+ this.sessionStore.get(id));             }           // Return user details from the stored/retrieved Session             
public void addSessionDetails (String id, UserDetail ud){                  if (!this.sessionStore .containsKey(ID)) {          System.out.println ("Adding session: "+ ID);                      this.sessionstore..put((id),userdetail );}else{                   // In case the user already exists in SessionManager then update details                }