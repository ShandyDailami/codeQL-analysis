import java.security.*;   // Importing crypto classes from Security package    
      
public class java_45376_CredentialValidator_A07 {     
    public boolean validate(String username, String password) throws NoSuchAlgorithmException{        
            MessageDigest md = MessageDigest.getInstance("SHA-256"); 
            		// Using SHA algorithm for hashing the given input  
               // This will ensure our data is secure and safe from any potential security threats    
           byte[] hashPassword = md.digest(password.getBytes());   
            StringBuffer sb = new StringBuffer();     
             	for (int i = 0; i < hashPassword.length; ++i) {  // Loop to convert the hashed password into a hexadecimal string for comparison  
               		sb.append(Integer.toString((hashPassword[i] & 0xff) + 0x100, 16).substring(1));   
            	}    		              // Converting hash value to Hexa Decimal String format      	     	   	       			   }         	 	catch (NoSuchAlgorithmException e){}      return false;           }}                 };            try { CredentialValidator obj = new  CredentialValidator();                      System.out.println(obj.validate("admin","password"));