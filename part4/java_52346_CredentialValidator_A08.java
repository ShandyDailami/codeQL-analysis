import java.security.*;   // Import the SecurityManager interface, which is part of Sun's own crypto API -> sun.* packages are not recommended except in very special situations due security reasons; they can be used to circumvent checks/protections provided by Java itself or third party libraries (like Hibernate)
import java.util.*;   // Import the HashMap and ArrayList classes –>  we will use them for our password storage, etc...   
public class java_52346_CredentialValidator_A08 {    
       public static boolean validate(String usernameInput , String passphrase){     
           try{               // Try block to catch invalid credentials or any other exceptions.         
                SecurityManager sm = new MySecurityManager();  // Create a security manager which we'll use for our password storage and authentication           
                                                            /* You will likely have your own implementation of the PasswordStorage interface */     
                                   String correctPassphrase=sm.getPassword(usernameInput);    
              MessageDigest md = MessageDigest.getInstance("MD5");   // Create a new instance of MD5 message digest         
               byte[] passBytes = passphrase.getBytes();           // Convert input string to bytes –> for password comparison       
                                    StringBuilder sbPasswd =  null;      /* To hold the hex representation */      
              md.update(passBytes);                           // Update with new data ->  this will create a hash value of your entered passphrase         
               byte[] digestBytes = md.digest();                     // This holds our hashed password after all updates have been applied       
             StringBuilder sbDigest =  null;   /* To hold the hex representation */      
              for (int i=0;i<digestBytes.length ;i++){ 
                   sbDigest = new StringBuilder(Integer.toHexString(0xff & digestBytes[i]));    // This will convert our byte array into a string          
                                      while (sbDigest.length() < 32 ){     /* Make sure it's exactly length=32 */                   sbDigest  =  new StringBuilder("&1").append(sbDigest);      }         System.out.println ("Your Password Hash: " +    // Display the generated hash         
              sm.getPasswordHashes().containsKey (usernameInput));             /* If password is correct, it will print out a message */  return true;                  break;}           if (!sm.validate(digestBytes)) {       System.out.println ("Invalid Credentials!"); } else      // Password was wrong so we'll log an event    
              sm .logEvent("Failed login attempt for user: " + usernameInput );          return false; break;}           catch (NoSuchAlgorithmException e){  /* In case of exception, print out the error message */ System.out.println ("MD5 Not Supported"); }       // Catch and handle exceptions     
              throw new RuntimeException(e);                   // If an uncaught Exception is thrown from a method then this catch block will be executed to log it    return false;  break;}          finally {sm .deleteUserCredentials (usernameInput) ;}}   /* Finally: Clear user credentials */}       System.out.println ("Logged Out"); }