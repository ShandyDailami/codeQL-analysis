import java.security.*; // Import cryptographic classes such as MessageDigest for hashing and SecureRandom to generate secure random numbers    
public class java_49034_CredentialValidator_A07 {      
      private HashMap<String, String> users;          
              
      public java_49034_CredentialValidator_A07() {             
          this.users = new HashMap<>();                 // Initialize a hashmap for storing user credentials               
                                  }                  
                                                         
     /* Method to add data */                 
   void createUser(String username, String password)  throws NoSuchAlgorithmException              
    {       if (username != null && password!=  null){              users.put(username , hashPassword(password));          }}             // Store the user name and its encrypted version in a HashMap        
                  
   /* Method to check data */                 
  boolean validateUserCredentials(String username, String inputPassword) throws NoSuchAlgorithmException      {       if (users.containsKey(username)){               return isMatchingPassword(inputPassword , users.get(username)); } else{ throw new InvalidParameterException("No such user exists!");}}          
                  
   /* Method for hashing a password */          private String hashPassword(String input) throws NoSuchAlgorithmException       {             MessageDigest md = MessageDigest.getInstance("SHA-256");              byte[] hashInBytes  = md.digest(input.getBytes());        return bytesToHex(hashInBytes); }                    
                                             // Method to convert a string into hexadecimal format         private String  bytesToHex (byte []bytes)    {             StringBuffer sb = new StringBuffer();              for (int i = 0; i < bytes.length; ++i){sb.append(Integer.toHexString((bytes[i] & 0xFF) | 0x100).substring(1,3));}         return    sb.toString() ; }  
                                                          // Method to check if two passwords are the same */                   boolean isMatchingPassword ( String input , String storedHash){             MessageDigest md = MessageDigest.getInstance("SHA-256");              byte[] hashInputBytes  =     md.digest(input.getBytes());         return bytesToHex(hashInputBytes).equalsIgnoreCase 
    //storedHash); }                   if (password_hasingMethod().equals() equals password) {return true;} else   return false;}}      private String getPasswordHavingSHA256(){            ......// Here you can write your own logic for generating the SHA-256 hash of a given string.