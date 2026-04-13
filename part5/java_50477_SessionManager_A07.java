import java.util.*;  // Importing necessary classes from Java Standard Library  
public class java_50477_SessionManager_A07 {    // Defining a public static main method that will run our program     
     private HashMap<String, String> userDB;          // Creates an empty hashmap to store users and their passwords      
       
         /* Initialize the session manager with some initial data */            
            public java_50477_SessionManager_A07() {             
                this.userDB = new HashMap<>();          
                
                  // Adding sample login credentials (You should normally use database operations here)   
                   userDB.put("John", "1234");     
               }      
     /* Method to check if a given username and password combination are valid */          public boolean isValidUser(String name, String pwd){              // This function checks the entered credentials against our database             System.out.println("\n\tEntering login...");            return userDB.get(name).equals(pwd) ? true : false;       }       
     /* Create a new session for that particular logged in user */          public Session createSession (String name){              // This function creates and associates an ID with the currently-logged-in person           if(!userDB.containsKey(name)) { System.out.println("\n\tUser not found"); return null; }            String sessionID = UUID.randomUUID().toString();       Session newSession  =new UserSession (sessionID, name);     this.sessionsMap .put(sessionID ,  newSession );            
        //return the newly created 'user' sessions      System.out.println("\n\tUser " +name+ "' has logged in session:'" +  userDB  +"'");   return null;       }         public Session getCurrentSession (String name){              if(sessionsMap .containsKey("current")) {           
        //return the currently-logged person             System.out.println("\n\tUser " +name+ "' is Loged in session:'" +  sessionsMap  +"'");    return null; }     public void logOut (String name){               if(sessionsMap .containsKey("current")) {            // User has to be logged-in first             Session currentSession =  
        getCurrentsession ("name" );  System.out.println("\n\tUser " +"(Logged Out)"+"'"); } return null;    }}