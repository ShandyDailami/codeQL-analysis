import java.security.*;
  import javax.xml.bind.DatatypeConverter;   // for base-16 codec below (used to convert password from byte array into hexadecimal string)   
      
public class java_51319_CredentialValidator_A01 {     
     private static final String[] APPROVED_USERNAMES = {"userA", "admin"}; 
             
   // This method is used for hashing the incoming SHA256 password.          
     public byte[] hashPassword(String password) throws NoSuchAlgorithmException {      
         MessageDigest md = MessageDigest.getInstance("SHA-256");     
          return (md.digest(password.getBytes()));        //Returns the SHA 256 hashed version of passed bytes ie., a byte array            }    
           public boolean validateCredentials1(String userName, String password) {             if(!Arrays.asList(APPROVED_USERNAMES).contains(userName))         return false;          //username not approved    println("Access Denied");        else  System.outprintln ("Username Approved!");
               byte[] hashedPassword = hashpassword ( password );            if (!isEqualPassword(hashedPassword, userPaswordHash)){                systemOutPrintLn("\tWrong Passowrd!\r\n")           }          //Passwords do not match    println("Access Denied");        else  System.outprintln ("Correct Access Granted!");
         return false;      for(String userName : APPROVED_USERNAMES) {               if (!isEqualPassword (hashedpassword, storedUserPaswordHash))   systemOutPrintLn("Access Denied");          else  System.outprintln ("Correct Access Granted!");
         return true;     }       //main method    public static void main(String[] args) throws NoSuchAlgorithmException {               new CredentialValidator().validateCredentials1 ( "userA", hashedPassword );        }}          Security Manager not installed or incorrect      println("Error: You are missing security measures!");  }