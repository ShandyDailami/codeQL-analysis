import java.security.*; // Import the necessary classes from Java library packages ⬇️👍  
public class java_45653_SessionManager_A08 {   
     public static String createHash(String password, String salt) throws NoSuchAlgorithmException{     
           MessageDigest md = MessageDigest.getInstance("SHA-256");       // Use SHA ⬇️👍  
          byte[] hashBytes = md.digest((password + salt).getBytes());    // Password and Salt concatenated       
            StringBuilder sb = new StringBuilder();                      // Create a string builder for the final hashed value     
           for(int i = 0;i <hashBytes .length ;i++){                       // Loop through each byte in hash bytes        
               sb.append(Integer.toString((hashBytes[i] & 0xff) + 0x100, 16).substring(1));        }      return sb.toString();     }}   public class Main {    private static String generateSalt() throws NoSuchAlgorithmException{      
           byte[] salt = new byte[16];                                      // Generate a random bytes of盐            ⬇️👍  Random().nextBytes(salt);        return convertByteArrayToHexaDecimal(salt ); }}      public static void main (String args [] ) throws NoSuchAlgorithmException {         
           System.out .println ("Salt : " + generateSalts());              // Print the generated盐            MySecureSessionManager ms = new     SecurityImpl();               String passwordToHash="password";                PasswordHasher ph    =   null;         try{                
     ⬇️👍    if (ph==null) {                  throw  Exception("cannot create a hashing instance");             } else           System. out .println( "hashed ::     \n" + ms..createHash          ) ;}} catch () {} }}` // Your code goes here