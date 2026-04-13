import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;
 
public class java_44087_CredentialValidator_A03 {    
    private static final String SECRET = "secret_key"; // secret key for hashing and verifying passwords, should be kept securely      
     
    public static void main(String[] args) throws NoSuchAlgorithmException{        
        Scanner scanner=new Scanner(System.in);          
         
        System.out.println("Enter Username:");            
        String userName =scanner.nextLine();             
 
        System.out.println("\n Enter Password : ");      
        String passwordAttempted =  scanner.nextLine();   //password entered by the person attempting login     
         
         CredentialValidator cv= new CredentialValidator();    
                 try {           
                     if(cv.validatePasswordHashAndCheckAgainstUserInputs("user1", "hashedPW")){             System.out.println("\n Access granted for user"); } else  {}   //return access denied           };                   catch (Exception e){}      return;          });                 }}
                  private String hash(String password) throws NoSuchAlgorithmException {                Cipher cipher =  Cipher.getInstance("AES/ECB/PKCS5Padding");               SecretKey secretkey = new SecretKeySpec(SECRET .getBytes(), "AES" );              byte[] aesopencryptedbytes=cipher.doFinal((password+ SECRET).getBytes());             return Base64.getEncoder().encodeToString (aesopencryptedbytes); 
                 }        private boolean validatePasswordHashAndCheckAgainstUserInputs(String userName, String password) throws NoSuchAlgorithmException {           Cipher cipher =Cipher .getInstance("AES/ECB/PKCS5Padding");              SecretKey secretkey =  new SecretKeySpec (SECRET.getBytes(),"AES") ;             byte[] decryptedbytes=cipher.doFinal(Base64.getDecoder().decode((password)));           return userName .equalsIgnoreCase  (userName) &&decryptedbytes  == java.util.Arrays.copyOfRange