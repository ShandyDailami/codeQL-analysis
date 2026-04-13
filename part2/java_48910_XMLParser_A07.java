import java.security.*;
// For input handling we can use BufferedReader for reading file content or Scanner class java_48910_XMLParser_A07 Java Standard Library if you are using console based inputs in your program:
class Main {  
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException{ 
        // Step a. Generate some random data that will serve as the key and IV for our encryption example      
        String secret = "ThisIsASecret";        
        KeyGenerator kgen =  KeyGenerator.getInstance("AES");         
        SecureRandom sr = new SecureRandom();    // Step c. Using a secure random number generator 
        kgen.init(128,sr);   // AES is always block size of 16 or 32 bytes (step b)    
        
       Key key =  kgen.generateKey();     
          byte [] iv = new byte[16];    /* Step e */       
           sr.nextBytes(iv);             /Step f and g   // Set Initialization Vector from a secure random number generator 
            System.out.println("IV: " +new sun.misc.BASE64Encoder().encode(iv));// Print the IV in hexadecimal format for security reasons     
         java.security.spec.AlgorithmParameterSpec spec = kgen.getParameters();     //Step h  This is just to print out Algorithm Parameters  
          System.out.println("Algorithm parameters: " + spec);    /* Step i */                 
        //Now we are ready for encryption and decryption process (assuming that the secret string should be encrypted beforehand)           
         String plaintext = "";     // The input data will come from a file, database etc  step d. You can use BufferedReader or Scanner to read this   
          byte[] encrypt =  key.getEncoded();   /* Step e */      
        for(int i=0;i<encrypt.length ; ++i ){         // Encode the secret string into hexadecimal format (step g)     
            System.out.print(Integer.toString((plaintext byte b), 16).toUpperCase() + " ");     }      
        String encryptedData = new sun.misc.BASE64Encoder().encode(encrypt);    // Encode the secret string into base-64 format (step h)      System.out.println("CipherText:  "+decrypteddata );// Decryption is also done here
         /* Step j */        }   catch(Exception ex){       printMessageForFailureToEncryptOrDecrypt();}    // In case of failure, we need a recovery mechanism to handle this exception and end the program.      finally{}  Ends all steps     };}}; This is an example with input from file which should be used in real world scenarios also for authentication failures