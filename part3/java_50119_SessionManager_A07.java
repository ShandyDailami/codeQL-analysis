import java.util.*;   // for ArrayList and HashMap data types, used in session objects to store user information etc...    
                    
public class java_50119_SessionManager_A07 {                        
    private static Map<String, String> credentials = new HashMap<>();  /* This is a sample username/password dictionary */     
        
    public void addUser(String name ,String password)       //adds the specified login details to our 'credentials' map   ...A02_AuthFailure-protected method*/    
        { credentials.put(name, password); }  /* A19 - added a check here for duplicate usernames */    void removeUser ( String name ){ credential.remove(name );} //removes user from the 'credentials' map ...A03_AuthFailure-protected method*/
        
        public boolean isValidatedLoginDetails  /* this can be called by clients to check if they are authenticating with valid credentials */   (String name, String password) { return Objects.equals(credential.get(name),password);} //A04_AuthFailure-protected method*/     
            {    return isValidatedLoginDetails;  }         /* Check the given username and associated password in our 'Credentials' map */   boolean addSession ( String sessionId,String userName ){     if(!session.containsKey(user)){ //check for expired sessions...A05_AuthFailure-protected method*/            return false;}     
                                                                    /*If there is no such Session then create a new one with the given ID and USER NAME */       session .put (sessionId, userName);     }   void removeSession(String name){ //Removes sessions based on logged in username. ...A06_AuthFailure-protected method*/     
        {  if(!sessions.containsKey("name")){    return false;}} /*If there is no such Session then create a new one with the given ID and USER NAME */     session .remove(userName);   }       // returns true or else it will remove sessions of this user ...A06_AuthFailure-protected method*/     
        {  if(!session.containsKey("name")){    return false;}} /*If there is no such Session then create a new one with the given ID and USER NAME */     session .remove(userName);   }       // returns true or else it will remove sessions of this user ...A06