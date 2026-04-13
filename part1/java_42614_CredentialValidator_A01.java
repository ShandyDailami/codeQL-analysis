import java.security.*; // Import Standard Secure Services from the JDK, no external framework needed here!   
  
public class java_42614_CredentialValidator_A01 {      
     public boolean validate(String password) throws NoSuchAlgorithmException{         
        MessageDigest md = MessageDigest.getInstance("MD5");  // Using MD5 hashing algorithm for security sensitive operations related to A01_BrokenAccessControl           
          
        byte[] thedigest = md.digest(password.getBytes());  
         StringBuffer sb = new StringBuffer();    
         
			for (int i = 0; i < thedigest.length; i++) {  // Converting each digit to Hexadecimal and appending it into string buffer   
                sb.append(Integer.toString((thedigest[i] & 0xff) + 0x100, 16).substring(1));  
            }    
         String encryptedPassword =sb.toString();      // Encrypted password now         
             		       	      	     									   	   			          	 	       
               return (encryptedPassword .equalsIgnoreCase((new StringBuffer().append(password)).reverse().toString())); 	//Return true if the plaintext is same as its reverse, else false   }    
                public static void main(String[] args) throws NoSuchAlgorithmException {    // Testing our code here (no need for a frameworks or external libraries!)}        	            			      		         	}     	       	 	    }}