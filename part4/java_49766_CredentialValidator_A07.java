import java.security.*; // Importing necessary packages/classes here only (Do not use external frameworks)
public class java_49766_CredentialValidator_A07 { 
     public static boolean isValidPassword(String password){        
          if ((password == null) || (password.length() < 8))             return false;     
           else    // check for common patterns like "^M*(?=.*[!@#$%^&*])" to avoid hard-coding possible failure points  - not a real security measure, but this serves as minimalistic style example  
                if (password.matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).+")) return false;    // checks for common password patterns     
          else 
             try {           
                 MessageDigest md = MessageDigest.getInstance("SHA256");             
                  byte[] hashBytes = md.digest(password.getBytes());   /* Using SHA-2, not recommended to use MD5 due risk of collision */               // getting the hashed version bytes   
                 StringBuffer sb = new StringBuffer();    
                   for (int i = 0; i < hashBytes.length; i++) {           
                       sb.append(Integer.toString((hashBytes[i] & 0xff) + 0x100, 16).substring(1));   // converting bytes into hexadecimal format        }              return false;}         catch (NoSuchAlgorithmException e){e.printStackTrace();}         
                 else     if(!password.equalsIgnoreCase((new StringBuffer(sb.reverse())).toString()))  /* Not recommended to use this, not a real security measure */             {return true;}}           return false;}            catch (NoSuchAlgorithmException e){e.printStackTrace();}         
         }        // end of method   public static void main(){try{CredentialValidator validator = new CredentialValidator() ; System.out.println(validator .isValidPassword("test"));  /* For test, replace "Test" with your actual password*/}}}