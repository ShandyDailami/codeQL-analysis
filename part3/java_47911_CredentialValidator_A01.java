import java.util.*;
public class java_47911_CredentialValidator_A01 {
    private static List<User> users = new ArrayList<>(); // This is where we'll store all our User objects - no good way to do this in production code!  You would probably use an actual database or some form of persistent storage here...
  
     public void addUsers(String username, String password) {        /* No Hash method on the user-password pair */
         users.add(new SimpleUser(username, password));              // In a real application we'd want to use hashing and salt for security reasons – this is just an example  
     }      public boolean authenticate (String username , String attempt) {    /* No Hash method on the user-password pair */                                                     
         return users.stream().anyMatch(user -> user.matchesCredentials(attempt)); // We'll use streams for this because we want to stop as soon a match is found, not all matches are needed – Again in real application there would be hashing and salt used here  
     }                                                              /* No method on password */                                                                                     public static void main (String [] args) {      // Main Method which will call the methods added above.        SimpleUser user = new User("testuser", "password");    addUsers(“admin”, “1234567890”);     System . out。println(. authenticate ("Admin" , password));
}                                                            /* This is a sample code which can be removed */