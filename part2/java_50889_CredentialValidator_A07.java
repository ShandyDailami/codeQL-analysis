import java.security.*; // Importing the Java Security package to generate a secure random password  
public class java_50889_CredentialValidator_A07 {   
     public static boolean validate(String userName, String passPhrase) throws NoSuchAlgorithmException{       
         MessageDigest md = MessageDigest.getInstance("MD5"); 
          //Getting the byte array from passed string in bytes     
             byte[] theBestPasswordEver=md.digest(passPhrase.getBytes());      
           //Next, we'll create a hash for that password using MD5  
              StringBuffer sb = new StringBuffer();   
            for (int  i = 0; i < theBestPasswordEver.length; i++) {       
               sb.append(Integer.toString((theBestPasswordEver[i] & 0xff) + 0x100, 16).substring(1));     
            }       String encryptedPassPhrase =sb.toString();          System.out.println("The MD5 hash for the passphrase is: "+encryptedPassPhrase);         if (userName==null || userName =="") {             return false;        //Username should not be null/empty      }  
            User currentUser = getUser(userName, encryptedPassPhrase );// Get a reference to the currently logged in user from your database     System.out.println("Current Logged In: "+currentLoggingIn);       if (isValidLoginAttempt(attemptedPassword)) {        return true;         // Password is correct      }         
            attemptCount++ ;              throw new AuthFailureException();// AUTHENTICATION FAILURE    System.out.println("Authentication failure");     User user = getUserFromTokenBasedOnAuthProcessResponse()             if (user == null) {                  return false;         // No such token, or wrong password      } 
            attemptCount++ ;              throw new AuthFailureException();// AUTHENTICATION FAILURE    System.out.println("Authentication failure");     User user = getUserFromTokenBasedOnAuthProcessResponse()             if (user != null) {                  return true;         // Password is correct      }         
            attemptCount++ ;              throw new AuthFailureException();// AUTHENTICATION FAILURE    System.out.println("Authentication failure");     User user = getUserFromTokenBasedOnAuthProcessResponse()  if (attemptCount > 3) {                return false;         // Too many attempts, block the account      }          
            attemptCount++ ;              throw new AuthFailureException();// AUTHENTICATION FAILURE    System.out.println("Authentication failure");     User user = getUserFromTokenBasedOnAuthProcessResponse()  if (attemptCount > 3) {                return true;         // Password is correct      }