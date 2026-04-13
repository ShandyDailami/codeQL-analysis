import java.security.*;
// Import BCRYPT library which is used specifically here: HashPassword, ValidatePassword  
class java_49581_CredentialValidator_A01 {   
     public static void main(String[] args) throws NoSuchAlgorithmException{      
         CredentialValidator validator = new MyCredentialValidator();       
         boolean result=validator.validate("John", "$2a$10$hFv/u5Ojr6QqP7KJgk3eRfLwzWBp9iZnU4bHlGXcDNmYA8SsVijx");  
         System.out.println(result);      // should print true    
    } 
}       
class MyCredentialValidator implements CredentialValidator {      
           public boolean validate (String username, String passwordToValidate) throws NoSuchAlgorithmException{             
               MessageDigest md = MessageDigest.getInstance("SHA-1");             // SHA algorithm for hashing               
               byte[] thehash=md.digest(passwordToValidate.getBytes());      
           
           StringBuilder sb = new StringBuilder();  
                  
              for (int i = 0; i < thehash.length ;i++) {     // convert hash into hex string format         
                    sb.append(Integer.toString((thehash[i] & 0xff) + 0x100, 16).substring(1));    }             
               String hashedPassword = sb.toString();      return (hashedPassword.equals(passwordToValidate)) ;     // returns true if password is correct          };        private class HashValidation implements CredentialValidator {   ... your code here .....  });       public static void main() throws NoSuchAlgorithmException{