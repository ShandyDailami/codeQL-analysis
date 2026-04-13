import java.security.MessageDigest;  // Import Java's Message Digest API for md5 hash function   
public class java_45932_CredentialValidator_A07 {  
     public static void main(String args[] ){     
         System.out.println("Md5 Password Manager");      
         
         String password = "password";  //inputted credentials (user provided)       
                  
         try   
         {          
             MessageDigest md=MessageDigest.getInstance("MD5");//using MD5 for hashing  
              
              byte[] messageDigest =md.digest(password.getBytes());      
          }    
      catch (Exception e)       
  {            System.out.println ("Something went wrong while generating the md5 hash!");           return;    }}                 //returning error if exception occurs               throw new RuntimeException("Error in MD5 hashing");   });                  MessageDigest.getInstance( "MD5" );     }       catch ( java.security.NoSuchAlgorithmException e ) {      System .out.println ("There's an issue with the encryption algorithm."); return;  }}