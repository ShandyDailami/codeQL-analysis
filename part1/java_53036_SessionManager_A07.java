public class java_53036_SessionManager_A07 {
    // We'll keep a user in memory for simplicity, but typically you would store this against some kind of session ID instead
   private User loggedInUser;    
     
       public void login(String username, String password) throws AuthenticationFailureException{       
            if (!isValidCredentials(username,password)) {  //custom exception here to handle authentication failure.               
                  throw new AuthFailed("Invalid credentials");                
             }         
              this.loggedInUser = getUserFromDBByNameAndPassword(username , password);    //Fetch user from DB  
       }    
      public void logout(){        
            loggedInUser=null; 
        }          
public boolean isLoggedin() {         
 if (this.loggedInUser== null) return false ; else true ;                  
}            
private User getUserFromDBByNameAndPassword(String username, String password){       //simulating a database call        
    System.out.println("Accessing DB to fetch user...");  
           if (username == "admin" && password=="password") {          return new User();}  else throw new IllegalArgumentException ("Invalid credentials");     }        private class AuthFailed extends RuntimeException{AuthFailed(String s){super(s)};}}    // custom exception to handle auth failure.