import java.util.*;
public class java_52427_CredentialValidator_A07 {    //class declaration with validator name 
     private static final String ABSTRACT_CHARSET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";   /* The set of characters that will be used to fill a buffer. */      //Define the possible password character 
     protected Random mRandom;   
       public String createPassword(int length) {         /**Create and return new random Password*/         
           StringBuilder passBuilder = new StringBuilder();        /* Create an instance of string builder class in java to build actual resultant */      // This will hold the final password. 
             mRandom =  new Random();    ///Creating a object for generating number from ABSTRACT_CHARSET   /**Generate random int inside range [0,ABSTRACT CHARACTER SET LENGTH]*/          .nextInt(length);       // Add to stringBuilder until the length limit is reached. 
             while(--length >= 0) {                  /* Append a char at this position in ABSTRACT_CHARSET onto pass builder */              mRandom = new Random();    /// Creating object for generating number from random class*/          .nextInt(ABSTRACT_CHARSET.length()) | Character.MIN_VALUE;   // Generate and add to stringBuilder until length limit is reached
             }        /* This loop will generate password character by char */  passBuilder = new StringBuilder();    /// Create a instance of builder class in java for constructing actual resultant*/      return ABSTRACT_CHARSET.charAt(mRandom .nextInt(ABSTRACT_CHARSET.length()));     // Return the final random generated string   }
}