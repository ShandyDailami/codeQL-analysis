public class java_49007_CredentialValidator_A03 {
    // Function for validating passwords - this is a simple validation but not secure. In real application it should be handled with security professionals who are experts in credential checking algorithms and protocols 
     public boolean validatePassword(String enteredPass, String encryptedDBpass) throws Exception{  
        if (enteredPass == null || encryptedDBpass==null){   
           throw new IllegalArgumentException("Arguments cannot be empty");      }        
               //compare passwords in database with submitted one using a secure hashing algorithm     return  entities.getPassword().equals(encrypted);}       default:   {return false;}}}