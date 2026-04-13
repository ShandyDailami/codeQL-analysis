import java.util.*;
  
public class java_52603_CredentialValidator_A01 {    // Scope this to be unique across all your classes and methods (A01_BrokenAccessControl) 
                                    // This is an example of creating a custom validator, not related specifically A01 Broken Access Control as it's more context-sensitive.  
    
// Define the list that will hold usernames/passwords for testing purposes: (A02_SecurityBreachAttempt) 
    private List<User> userList;      // This is a placeholder, you would replace this with your actual User object to test CredentialValidator  
                                    // It also serves as an indicator of where the security-sensitive operations will occur in our validation process.    
                                    
// Implementing constructor (A03_SecurityBreachAttempt)  :    You need a way for usernames and passwords to be set up at some point during initialization,   // here we just add them manually:     
public java_52603_CredentialValidator_A01() {       // Scope of this is unique within your class/method (A01_BrokenAccessControl) 
    userList = new ArrayList<>();     // Here you are adding users to the list with known credentials for testing.   In actual use, replace these lines as necessary:      User testUser;             // Initializing a Testuser             
                                                                                                                             passwordHasher = new BCryptPasswordEncoder(12);  /* Use Bcrypt or similar suitable algorithm */    }