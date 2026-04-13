import org.apache.commons.codec.binary.Hex;
   import java.security.*;
    public class java_53198_SessionManager_A07 {        // Declare a new session manager for our application (or library) named 'Session Manager' in plain Java, no framework needed here!    
      private HashMap<String , String> userCredentials ;  // A simple hashmap to store username and passwords. Security should not be an issue unless you are dealing with sensitive data like access tokens or API keys etc., so use it wisely!!         
    public java_53198_SessionManager_A07() {                   // Constructor, initialize our HashMap (no external dependencies here! just standard Java features)            
      this.userCredentials = new HashMap<>(); 
     }      
        private String generateSessionKey(String username){          
         MessageDigest digest;                      /* Create a message digest instance and update it with the key bytes */  
            try {                              // Try block to handle possible exceptions             
                digest =  MessageDigest.getInstance("SHA-256");  /** Use SHA algorithm (not recommended for security sensitive operations) **/    
                 byte[] hash = digest.digest(username.getBytes("UTF-8"));    /* Applies sha algorithm on username string and gets the hash value result */   // Updates data and calculate new hash               
                  return Hex.encodeHexString(hash);  /** Converts bytes to hexadecimal format **/      
             } catch (NoSuchAlgorithmException e) {     /* In case of exception, print an error message then rethrow */    // Catches block for No Such Algorithm Exception          .   E.g., SHA-256 is used here but you can use any algorithm based on your requirement          
                System.out.println("Unable to generate session key");  e.printStackTrace();             return null;      } catch (UnsupportedEncodingException e) {     // Catches block for UnSupported Encoding Exception          .   E.g., UTF-8 is used here but you can use any encoding based on your requirement          
                System.out.println("Invalid character in the source");  return null;      }      
         }        private void addUser(String username, String password){     // Adds new user to our hashmap          this.userCredentials .put (username , generateSessionKey ) ;    /* Generates a session key and adds it into map with its corresponding name */   System.out.println ("Added User: " + "\""+ username  +"\", Session Key : \"" + 
generateSessionKey(username) );      }     public static void main (String[] args){          // Testing our method            new  sessionManager().addUser("user1","password");new   SesssionManger.              addUer (" user2 "," password "); System .out -println (. getSessionKey(..) );      }