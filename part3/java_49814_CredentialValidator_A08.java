import java.security.*; // Importing standard libraries to handle hashing and messages digests    

public class java_49814_CredentialValidator_A08 {  
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException{      
        String password = "password";        
          
        MessageDigest md = MessageDigest.getInstance("SHA-256"); // Using SHA-256 algorithm for hashing  
          byte [] hashPasswordBytes =  md.digest(password.getBytes()); 
              
          StringBuilder sb = new StringBuilder();          
        
        for (int i=0; i<hashPasswordBytes.length ;i++){           
                sb.append(Integer.toString((hashPasswordBytes[i] & 0xff) + 0x100, 16).substring(1));            
        }   
         String storedHash =sb.toString();   //Storing the hash in string format    
          System.out.println("The hashed password is : "+storedHash);             
          
      /* Compare this with database or secure storage */ 
      		
	}	
}`