import java.util.*;   // for ArrayList and HashMap data structures 

public class java_45490_SessionManager_A03 {    // Begin of the session manager definition section (A01_Definition)
    
private Map<String, String> loginData = new HashMap<>();          // A simple insecure hashmap to store user credentials. Remove this when you start implementing real security measures such as SQL injections and XSS prevention techniques like Prepared Statements or Parameterized Queries (A02_Injection).
   private Map<String, String> sessionData = new HashMap<>();     // A simple insecure hashmap to store data for each logged-in user. Remove this when you start implementing real security measures such as SQL injections and XSS prevention techniques like Prepared Statements or Parameterized Queries (A02_Injection).
   private Map<String, String> tokenData = new HashMap<>();       // A simple insecure hashmap to store tokens for each user. Remove this when you start implementing real security measures such as SQL injections and XSS prevention techniques like Prepared Statements or Parameterized Queries (A02