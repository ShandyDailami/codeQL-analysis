import java.security.*;   // Import Java Security classes needed to create MessageDigest object, get the message digest etc   
    
public class java_49318_CredentialValidator_A07 implements CredentialValidator {     
       private final String secretKey;          // Our 'master' password/secret key for encrypting our data 
       
       public java_49318_CredentialValidator_A07(String masterPassword) throws NoSuchAlgorithmException{   // The constructor sets the Master Password   
           MessageDigest md = MessageDigest.getInstance("SHA-256");     /* Create a new instance of SHA - Secure Hash Algorithm */ 
	         byte[] hashBytes = md.digest(masterPassword.getBytes());   // Get password hashed using our secret key   
		       this.secretKey =  bytesToHexaDecimal(hashBytes);      /* Store the result in a new variable for use later*/    
            } 
        @Override                                            public boolean validate(Credential cred) throws CredentialValidationException {   // Here we're going to check if our login attempt is successful. If not, an exception will be thrown with useful information about why it failed         
	         MessageDigest md = MessageDigest.getInstance("SHA-256");     /* Create a new instance of SHA - Secure Hash Algorithm */ 
		       byte[] hashBytes = md.digest(cred.getCredential().getBytes()); // Get password hashed using our secret key   
	         String enteredPasswordHash =  bytesToHexaDecimal(hashBytes);   /* get the Hashed value of inputted credentials*/    
            if (enteredPasswordHash .equals(this.secretKey)) {          return true;  } else{ throw new CredentialValidationException("Authentication failed!");}    // If they match, we're going to say yes and exit otherwise error with a message  
        }             public static String bytesToHexaDecimal(byte[] bytes) {     /* this method converts the byte values into hexadecimals */     
            if (bytes == null){  return "";}                      //if there is no data to convert, just give empty string.  
	        StringBuilder sb = new StringBuilder();       	// create a buffer of digits      
           for(int i=0;i< bytes.length ;i++) {        	     /* loop through all the inputted byte values */ 
               int n = 0xff & bytes[i];                 // make sure we only consider valid hexadecimal characters   		            	   			     	        }                sb.append(Integer.toString((n | 0x20),16).substring(1));        return sb .toString();	     /* Return the result */  
       }}  ;; -.-'-.'-./.-'..'.`+=#$%& '()*~,:;<.>@.,?/]{:/}^[[:alnum:]\\(\\).][]+|_]', ',';./<>(){}[\][\];:@,./\""