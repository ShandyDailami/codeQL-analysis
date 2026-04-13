import org.apache.commons.codec.binary.Base64;
import java.nio.charset.StandardCharsets;
import java.security.*;
import javax.crypto.Cipher;
import com.google.common.hash.Hashing; // for password hashing using SHA-256 
  
public class java_50604_CredentialValidator_A08 {   
    
       public static final String SECRET_KEY = "mySecretKey";          /*<-- This should be kept secret, and is used as a key */     
       
         /** Username for authentication*/          
       private Map <String , User> userMap ;  // using map to hold users data in memory (security sensitive)   
  
     public class User{            
          String passwordHash;            /*<-- This is the hashed version of a username's plaintext password */        
        }     
      
public java_50604_CredentialValidator_A08() {           userMap = new HashMap <>() ;                // Initialize an empty map.  
    public void addUser(String name, String pass){              User u =  new  User();             /*<-- Create a temporary username and password hash */        	           		     	 			              				      	   	        }           private MessageDigest md;     /** Hashing algorithm over SHA-256.*/
   public void addUser(String name, String pass){    this .addUser (name ,Hashing..hashPassword(pass));  // Add user and password hash to the map               			     	 	       }           private boolean validateCredentialsInternal (final byte[] salt , final int iterations) {        MessageDigest digest ;
   public void addUsersFromFile(){/*<-- Function for adding users from a file. This is just an example, use this as start and not finished yet */         try{              FileInputStream fis = new  java .io . FileInputStream ("/path/to/yourfile");             InputStreamReader isr = 
  新        BufferedReader reader=new    StringReader(isr);String line;while ((line=  reade.readLine()) !==null){if (!((passs == null) && pass2 = r  e .next())){ } else { /* if user already exists , add it to the map, otherwise create a new one */}
   this._users[i]=new User();this    _userNames [ i ] =  line;     md  =MessageDigest.getInstance("SHA-256");            digest =          MessageDigest .getInstance ("MD5" );md.update(salt+iterations);digist
   }catch (Exception e) {e.printStackTrace();}  return null ;           public static String hashPassword(String passwordToHash){        // Hash a plain text using SHA-256 and returns the hashed string       MessageDigest messageDigest = new    java .security .MessageDigest  
     "SHA-256";byte[] bytesOfPassword  =password.getBytes();          StringBuilder sb = 	new 	StringBuilder(30);for (int i= 1;i <=bytesof password +8 ; ++I) {sb    append ((char)(Byte ... )+...++ + ^ ); }
   return hash_256..hash ..toHex();            // Creates the hashed string using SHA-3.  In this example, we are only demonstrating two digits of precision and use it for simplicity */       /*<-- Function to check if passwords match in an enterprise style manner*/
   public boolean validatePassword(String name , String pass){           // We compare the hashed values instead plaintext versions because SHA is more secure than using a simple string comparison.         byte[] salt = getSalt (name);             User user =  this .userMap   		.get    	(  );          if (! MessageDigest   AES.getInstance ("AES").matches(salt, user)) {return false;}
       try{MessageDigest md=javax..crypto...Cipher;byte[] theEntireHashValue =md .digest (passToCheck+ pass);if    	(!Arrays ..equals  ...the entire hash value of    password , ....   ) return      fALSE ;           }catch(Exception e){e.printStackTrace();}return false;}
        public static void main (String [] args) {// Testing the classes and methods */          CredentialValidator cv = new    		 	CredentialValidator;cv . addUser("John" , "password");   if(!    (!(cv .. validatePassword ("Johh",     					"passw0rd")))) System.out.println (“Invalid credentials"));else       
System.. out . println("\n Validated...");}  }`// End of CredentialValidator example program in Java, do not forget to remove the comments and add your own logic for other security-sensitive operations like A08_IntegrityFailure. Please use this as a basis or start developing more secure applications using these principles with proper error handling (e.g., try/catch blocks), encryption methods etc!