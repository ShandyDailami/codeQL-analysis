import org.mindrot.jbcrypt.*; // Import Bcrypt package for hashing password and comparing to plaintext version of hashpassword  
public class java_50218_CredentialValidator_A07 {   
     public static boolean validate(String username, String password) throws Exception 
      {       
          if (username == null || password==null){              System.out.println("Username or Password is empty");            return false;}          
         // assuming that the real data validation happens here            
               try{                 BcryptHashPasswordHasher hasher = new org.mindrot.jbcrypt.*;                String encryptedPass="$2a$10$EIRRX/ZnKhNdM3H9QqLvlWtGw4Ff8g6Dz5kpV7OAJTu"; //This is example, should be replaced with real hash            
               if(hasher.check(password , encryptedPass)){                System.out.println("Credentials match");            return true;}           }  catch (Exception ex){              throw new Exception ("User not found" + username);        }}     public static void main() throws exception    {         CredentialValidator validate =new CredentialValidator();            
          String user= "test";   //Replace with actual value and also replace the password in real scenario  string passw0rd = 
      }}}//End of class