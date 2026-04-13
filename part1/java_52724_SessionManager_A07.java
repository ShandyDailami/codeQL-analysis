import java.util.*;   // Import the utilities package if needed 
    import javax.security.auth.*;   // For AuthenticationExceptions, provide access to AuthFailure exceptions only    
public class java_52724_SessionManager_A07 {      // Declare your session manager as a public java_52724_SessionManager_A07(unless you want it's accessible outside of this file) Singleton Class with private instance      
private static final List<String> authorizedUsers = new ArrayList<>();  /* Define user credentials */   
  
// Login functionality - User will be authenticated if they provide valid username and password.    
public boolean login(String user, String pwd){      // Checking for the correct entered details in this method      
if (user != null && user.length() > 0) {        /* If provided credentials are not empty */    return authorizedUsers.contains(user); } else   if  (!AuthZSubject.isAuthenticated()) AuthFailedException _e = new AuthFailedException("Must be authenticated!");     
_e .initialize();          // Raising an exception to indicate a failure authentication        throw _ e;    return false;}     /* If user does not exist */ else if (pwd != null && pwd.length() > 0) {        
if (!(user instanceof MyUser))  AuthFailedException __e = new   AuthFailedException("Invalid User");      // Raising an exception to indicate invalid credentials       _ e .initialize();     throw    __e;        return false;} else /* All credential are correct */          if (user != null) authorizedUsers.add( user); 
return true ;}             public boolean logout(String username){      // Logging out functionality - Removing the users credentials from 'authorized Users' list      
if (!AuthZSubject .isAuthenticated()) AuthFailedException __e = new   AuthFailedException("Must be authenticated!");     _ e.initialize();    throw  __e;        return false;}      /* If logged out successfully */ else if (username != null) {         authorizedUsers.remove( username );      
return true ; }           // Main method to start the program - Do not remove this comment or it will cause a compile error     public static void main(String[] args){        SessionManager sm = new    SessionManager();      try{sm . login("John", "password123");}catch (AuthFailedException e) {System.out...