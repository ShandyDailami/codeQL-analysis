import java.security.*;
public class java_53855_CredentialValidator_A08 {  
    public boolean validate(String passwordAttempt, String expectedPassword) throws NoSuchAlgorithmException{     
        MessageDigest md = MessageDigest.getInstance("SHA-256");     //We use SHA for hashing purpose to ensure data integrity and prevent rainbow table attacks 
        byte[] hash1=md.digest(passwordAttempt.getBytes());       //hash of password attempt   
        
           md = MessageDigest.getInstance("SHA-256");               
          byte[] hash2  = md.digest(expectedPassword.getBytes());   //hashed version stored in database  expected one (rainbow table)    
        if(!Arrays.equals(hash1,hash2)){                             //compare hashes of password attempt and the saved ones - returns true or false   	      
           return false;                                            	//if they are not equal then we fail to authenticate so it's an integrity failure 		   }              	       	 
        SecureRandom sr = new SecureRandom();      //create a secure random number generator        	     									    															           	   			   	      						         ​                                        .equals(hash1)                              (sr.nextInt() + "")                          Arrays                                           CredentialValidator  arra y p