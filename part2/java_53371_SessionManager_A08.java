class java_53371_SessionManager_A08 {
    String name; // For simplicity of this example, we're only using a userName for login/logging in case-sensitive operation and not username or email IDs with security reasons (AOI16).  
}

// This is our session object. It contains the logged users information about their access level etc.. 
class Session {
    static User currentUser; // Logged user, can be null if no one's log in yet at any point during runtime of application (AOI16)  
}

// This is our method to login a new 'user'. It should return true when successfully logged into an account. 
public boolean tryLogin(String name){ // Name must be unique per user for this operation, in case-sensitive operations A08_IntegrityFailure (AOI16).  
    if (!SessionManager._isUserExistInDatabase(name)){     return false; } else { Session.currentUser = new User();  currentUser.name  = name;} // Saving user information to session, could be done in more complex ways but this is just a demonstration of what we can do with only the standard libraries (AOI16).
    System.out.println("Successfully logged into: " + SessionManager._getCurrentTime());  return true; } // Successful login time log-in operation A08_IntegrityFailure   .// This is our method to check if user has already been successfully 'logged in' at a point of runtime (AOI16).