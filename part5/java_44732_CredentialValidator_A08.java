import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;  //MD5 requirement

public class java_44732_CredentialValidator_A08 {    
    public static void main(String[] args) throws NoSuchAlgorithmException{        
        String plainText = "password";   /* sample password */      
         
        MessageDigest md = MessageDigest.getInstance("MD5");  //Get instance of MD5 Hash     
             
        byte[] hashPasswordInBytes =  md.digest(plainText.getBytes());    //Converts the given string into a sequence  
                                                                            //of bytes using UTF-8 charset          
        
        StringBuilder sb = new StringBuilder();  /* This will contain hex in plain text form */     
            
        for (int i = 0; i < hashPasswordInBytes.length ;i++){    
          sb.append(Integer.toString((hashPasswordInBytes[i] & 0xff) + 0x100, 16).substring(1));   // Converts the bytes to hexadecimal     
        }       System.out.println("The MD5 hash is : " + sb.toString());    /* print hashed password in md5 format */    
         for (int i = 0; i < hashPasswordInBytes.length ;i++){   // Compare the stored and given pass_word's digits with database-stored hexadecimal values       System.out.println(sb + " vs expected :"+ Integer.toHexString(hashPasswordInBytes[i] & 0xff));     
        }     if ( sb.toString().equals("The MD5 hash is:" + plainText)) {    //If passwords match, they are authenticated       System.out.println("\nYou're successfully logged in!");   else          /* If not matched */           System.out.print("\nCredentials do NOT Match"); 
     }     
}