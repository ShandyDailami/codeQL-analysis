import java.nio.charset.StandardCharsets;
import javax.crypto.*;
import java.security.MessageDigest;  // Java Cryptography Architecture (JCA) standard interface to the message digest algorithms such as MD5, SHA-1 etc which is used for hashing passwords in legacy systems using md5 hash function.  
import org.bouncycastle.crypto.digests.*;   
// Importing BouncyCastle library from Oracle since it provides a different implementation of the same algorithm that we use here to ensure compatibility with JCE (Java Cryptography Extension)  which is one part used by OpenSSL in many systems now, and also has improved security against attacks.  
import java.util.*;    // Importing Scanner class java_47314_CredentialValidator_A01 Java utility package for taking input as command line argument can be an alternative way to make the program accept inputs via terminal arguments or user-inputs using console like scanf etc...  but this was not required in current context so we used it here directly
  
public final class CredentialValidator {    // Final modifier is necessary since our classes cannot inherit from other one (Java doesn't support multiple levels of Inheritance) and can also prevent any changes to their state or behavior.  Only methods declared within the same file are allowed inside a non-static context in Java, only variables/methods that have been either public accessible outside this class nor protected not accessed directly by another classes (which is default access level).
{    // This sets up an indent block and it's necessary as per java syntax.  A 'java file must end with one of the following'; {} or ; ':'.   An error here could lead to unexpected behavior in a code if not handled properly - hence final modifier is used for this CredentialValidator class only
    
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException {  // Declaring method declaration and its parameters. Annotations (@.. ) are placed before the function name in Java which includes methods like @Override that is not present here because we don't need to override it
        Scanner s = new Scanner(System.in);   /* Creating a scan object for taking input from user */  // Using built-it java utility class,Scanneer can take inputs as command line arguments and also console like printf etc.. but this was not required in current context so used it directly here
        
        System.out.println("Enter the password: ");   /* Prints a string on screen (for user interaction) */  // Java Console I/O, similar to scanf or cout from C++ using standard library only for outputting data and not taking input like in java console application you can't take command line inputs as it was done previously.
        
        String enteredPassword = s.next();   /* Reads a string of characters (password) */  // Java Console I/O, similar to scanf or cin from C++ using standard library only for reading data and not taking input like in java console application you can't take command line inputs as it was done previously
        
        String hashedPassword = hashMd5(enteredPassword); /* Hashes the entered password */  // Creates a new md5 object with digest.update() method for each character of an arbitrary length and then finally finish(), returns hexadecimal format (string) in base64 encoded data using MessageDigest's instance MD5 is used to hash
        
        /* You can also use BouncyCastle here */  // Java Cryptography Architecture provides APIs that offer improved security against attacks. This library, however as we are not directly interfacing with the JCA libraries in this example (Java has no built-in mechanism for MD5), it is left out of our code
        
        System.out.println("You entered: " + enteredPassword);   /* Prints a string on screen */  // For debugging purpose, prints password you've inputted by user in terminal or console output and not used here (as we don’t use this for actual hashing/checking)
        
        System.out.println("Hashed: " + hashedPassword);   /* Prints a string on screen */  // For debugging purpose, prints hash of the password entered by user in terminal or console output and not used here (as we don’t use this for actual hashing/checking)
        
        if(hashedPassword.equals("8c69e2537de84fbdada0aaf7b1bcdaad")) // This is a hard-typed password which should be provided in real world applications, but as per current context it can remain for now   /* Checks whether the hashes are equal or not */ 
        {    System.out.println("Access Granted!"); }     else          {System.out.println("Sorry you have entered wrong password.");} // This is a hard-typed check which should be provided in real world applications, but as per current context it can remain for now   /* Checks if hashed inputted Password matches the expected one */
    }}  end of main method and start again from this point. If you want to use BouncyCastle or any other library then just replace 'MessageDigest' with its equivalent in that case, similarly as done for MD5 hash above until we reach our current context where all standard libraries are used only