import javax.crypto.*;   // For encryption/decryption, used Cipher256 instead of the full JavaCryptographyUtils package which contains all cryptographic functions
                          // Also note that you need a strong secret key for this example (i'm using default one here) 
        
public class java_48084_SessionManager_A03 {    
    private SecretKey key;   // Our unique, secure encryption and decryption keys. Use better randomness!      
            
    public void init() throws NoSuchProviderException, NoSuchAlgorithmException{     
        KeyGenerator kg = KeyGenerator.getInstance("AES"); 
                                                    // A secret-key based on the provider's security standards    
                                                                   /* This could be a weak key or an empty string for simplicity */         
        	kg.init(128);                  
            this.key= kg.generateKey();          
    }       
            
       public byte[] encryptData (byte [] plainText){  //Encryption function  
                try {     Cipher cipher =Cipher.getInstance("AES");      /*Instantiate with the right key*/         	        		           	   				                  					                 	 			                 .init(Cipher.ENCRYPT_MODE, this.key);   								  } catch (Exception e){e.printStackTrace();}       
                return cipher.doFinal(plainText );              //Decryption function   /*Use the correct key here*/        		                   				                 	     .encryptData("This is sample text");     			                  					      	}   	 						  Catch block for exception handling in Java */          }                      public static void main (String[] args) throws NoSuchProviderException,NoSuchAlgorithmException { SecureSessionManager ssm = newSecureSesssionmanager();                 
                                                                             ss.init(128);   /*Here is the key initialization*/                    	ssm .encryptData("ThisIsJustASampleText".getBytes());  */                   }    //Encryption and Decription functions                      public static void main (String[] args) throws NoSuchProviderException,NoSuchAlgorithm Exception { SecureSessionManager ssm = newSecureSesssionmanager();     ss.init(128);   /*Here is the key initialization*/                    	ssm .encryptData("ThisIsJustASampleText".getBytes());  */                   }    //Encryption and Decription functions