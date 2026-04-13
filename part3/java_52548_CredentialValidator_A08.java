import java.security.*; // Import cryptographic operations and primitives, including hash functions such as SHA-256 algorithm  
public class java_52548_CredentialValidator_A08 {   
     public static boolean validate(String enteredPassword) throws NoSuchAlgorithmException{        
          String password = "admin";  // Hashed 'password' for security. You can use hashing algorithms like BCrypt, which is a widely used one by nowadays companies to secure user data such as plain text ones    
           MessageDigest md;  
            byte[] hashInBytes;   
            
          /* Create MD5 Hash */        
               try {     
                   //Create MessageDigest instance for MD5      
                      md = MessageDigest.getInstance("MD5"); 
                  } catch (NoSuchAlgorithmException e) {  
                    System.out.println(e.getMessage());    return false;    
                 };       
            
          /* Add password byte to digest */        
              md.update(enteredPassword.getBytes());     
          
            // Get the hash's bytes 
               hashInBytes = md.digest();      
               
            // Convert it into Hexadecimal format     (This step is important)   
             StringBuilder sb = new StringBuilder();  
          for(int i=0; i< hashInBytes.length ;i++){     
                  sb.append(Integer.toString((hashInBytes[i] & 0xff) + 0x100, 16).substring(1));    }    
              String generatedPasswordHash =sb.toString();  
         // return whether entered password and the hashed 'password' match or not     
             if (generatedPasswordHash == null || !generatedPasswordHash.equals(password)) {           System.out.println("Invalid Credentials");        return false;     }    else{ 
                  System.out.println("\nCredential Validation Successful!");            // Display success message         return true;}      };   });               new NoSuchAlgorithmException();                break default case: ;}              c + '+''); }}             catch (NoSuchPaddingException e) {e.printStackTrace()})}