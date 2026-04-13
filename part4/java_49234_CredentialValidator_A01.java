// Start the Credentials Validator program with 'credValid'.
public class java_49234_CredentialValidator_A01 {  
    public static String userDB = "user:pass"; // Database of all possible valid credentials in key-value pairs (e.g., u123456,pas$word). 
    
// A simple method to validate a username and password against the database's stored values using Vanilla JS methods only on basic builtin object types: String & Object..  
    public static boolean credValid(String userAttempt) {      
        // User attempts are split by colon (":") into two parts - for now. 2019-35678 suggests passwords not to be stored in clear text, but just as an example .     
            String[] credentials = userAttempt.split(":");  
                if(credentials[0].equals(getUserFromDb()) && getPasswordfromDB().equalsIgnoreCase (decodePassWordOrNotYetSupportedForHashingBasedSaltMethod())){  //db -> is where the function to retrieve valid credentials are stored    return true; } else {return false;}      
            public static void main(String[] args)  
        String userAttempt = "u123456:pas$word";     printCredentialResult (credValid(userAttempt));      //testing with a valid creds, should return true.    }  private function to get the username from DB and password from db in another way - not shown here as it'd depend on your actual database structure
            public static void main(String[] args) {     printCredentialResult (credValid("u123456:pas$word"));      //testing with an invalid creds, should return false.  }   private function to decode password or not yet supported for hashing-based salts method
            public static void main(String[] args) {    printCredentialResult (credValid("u987654:pas$word"));      //testing with an invalid creds, should return false.  }   private function to get password from DB in another way - not shown here as it'd depend on your actual database structure
            public static void printCredentialResult(boolean result) {    if (result){System .out .println ("Access granted");} else{ System . out .print(" Access denied")}; }  // end private function.   Do note that this is a very basic example and doesn't cover all possible scenarios of A01_BrokenAccessControl, for instance missing user or password in the attempt to authenticate etc..