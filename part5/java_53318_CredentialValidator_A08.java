import java.security.*;
  import javax.crypto.*;
  
public class java_53318_CredentialValidator_A08 {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException{
        // create keys for encryption and decryption process using SHA1 algorithm (for demonstration purpose only!)    
       Key a = KeyGenerator.getInstance("AES").generateKey();  
        
	MessageDigest md= MessageDigest.getInstance("MD5");  /* we use MD5 because it's simple */   
        // let user provide input for username and password (for demonstration purpose only!)    
       String passInput = getPasswdFromUser(a);     
  	    byte[] thedigest = md.digest(passInput.getBytes());        
          	byte [] dg=md5_hash20(thedigest, "AES");  //convert it to string         
        String passDB =  new String (dg );    
              System.out.println ("Password from user:   "+passInput);     		      				   			          	System. out . println("Stored Password in DB:" + passDB) ;  //to compare encrypted passwords	   	        if(passInput == null || (passDB !=null && (!passInput.equalsIgnoreCase(passDB))) ) {            System .out.println ("Integrity Failure"); } else{System . out . println("Authentication successful")；}
   	    			  				  // end of code                 					        			}            	        catch (Exception e) {}             	   	  }}                                               AES                     MD5                    ECDSA                      S2PFSSHFP                HMACSHA1                        CLAIMS_INIT          JCE