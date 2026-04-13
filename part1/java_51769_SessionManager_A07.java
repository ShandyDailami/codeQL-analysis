import java.util.*;  // Import HashMap library; used extensively in this example   
public class java_51769_SessionManager_A07 {   // Create a public session manager    
HashMap<String, String> userDB = new HashMap<>();      // Declare and initialize the database of users ie (user names: passwords)         
static int failedAttemptCount = 0;  // Count for number attempts made to fail authentication.  
    SessionManager(){           // Constructor        
        populateUserDatabase();     // Populates userDB with dummy credentials     
}       public static void main(String[] args){            new SessionManager(); }              System.out.println("Welcome!");                   String username, password;                    Scanner scan = new Scanner (System.in) ;         while((username=scan .next()).equals ("exit")) {                 if(!authenticateUser() ){                     failedAttemptCount++;} else   
if(failedAttemptCount > 2){ System.out.println("Too many attempts, account has been locked!"); break; }                  else 
System. out .print ( "\nSuccessfully logged in! \ n" ); }} // Successful login exit loop            private boolean authenticateUser(){           String inputUsername = "user",              stringInputPassword=             getNextFailureAttempt();                     if(inputUsername==null ||                 userDB.get("John") == null){ return false; }                 
if(!inputUsername .equals (username)){ // If not equal to username in database then fail     
// check password is correct otherwise          }} else {                    String inputPassword = "password",             if(userDB. get (" John ")==null || ! user DB   ].get("John"). equals              (stringInputPassword ){ return false; }                  // If the entered username and saved ones are not equal then fail           
return true;}    private static void populateUserDatabase(){          userDB .put ("Alex", "password1");             UserDetails u = new                     User.Credentials("John"," password2") { public boolean equals(Object               o){ // Included in the method for authentication purpose   } return false; }}