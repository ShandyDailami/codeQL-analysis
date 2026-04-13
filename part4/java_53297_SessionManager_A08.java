import javax.crypto.*;
class java_53297_SessionManager_A08 {    
    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException{      
        String username = "user1";        
        byte [] userDataToStore= createUserCredentialHash("password",username);         
           System.out.println("\nStoring User Data in Session\n"); 
            storeSession(userDataToStore,"sessionID_for_"+username );   //stores session id and username together to identify the user later on, for simplicity we're assuming that all usernames are unique      
           System.out.println("User data stored successfully.");            
         } 
     private static byte[] createUserCredentialHash(String credentialToStore , String randomData) throws NoSuchAlgorithmException{   //this method creates hash for the user's input (credentials and username together), we can use any algorithm to ensure integrity of session data. Here, SHA-256 is used here as a demonstration
           MessageDigest md = MessageDigest.getInstance("SHA-256");         //Create instance of MD5 Hash  
          byte [] hashPassword=md.digest( (credentialToStore + randomData).getBytes() ); 
            return hashPassword;        }      private static void storeSession(byte[] userCreds, String sessionID) {     /*this method stores the generated credentals into browser local storage using JavaScript's Web Storage API*/       LocalStorage.setItem("session", JSON.stringify({"id":sessionID,"userData":userCreds})); }  
    public static boolean verifySession(String username, byte[] expectedHash) throws NoSuchPaddingException, InvalidKeyException {     /*this method fetches the session' user data from browser local storage and compares it with our stored hash. This is a demonstration of how to ensure integrity in A08_IntegrityFailure scenario*/
       String retrievedSessionData= LocalStorage.getItem("session");   //fetching saved sessions      if(retrievedSessionData == null) {return false;}  byte[] actualHash = JSON.parseObject(retrievedSessionData, UserCredentialsInfo.class).userData;     return Arrays.equals(expectedHash ,actualHash); }
}