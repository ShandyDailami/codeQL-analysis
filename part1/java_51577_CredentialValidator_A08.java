import java.nio.charset.*;
import javax.crypto.*;
import org.junit.jupiter.api.Test;
// Importing assert library for testing purpose, since we are not allowed to use external frameworks (like Spring or Hibernate) 
static final String TEST_STRING = "Hello World!";   // A test string that will be hashed and validated against a hash value later on.
import static org.junit.jupiter.api.Assertions.*;   
// assert library to validate the results of our code, if an error occurs it fails so we can catch exceptions appropriately at runtime 
class java_51577_CredentialValidator_A08 {   // Our credential validation class should inherit from java's Object type for more flexibility later on in your program...    
public String createHash(String input) throws NoSuchAlgorithmException{    /// Method to encrypt our test string using SHA-256 Hash Algorithm.  \\\ Returns a hex representation of the hash as a plain text password/hash value that can be compared for equality, and stored in your database
   MessageDigest md = MessageDigest.getInstance("SHA-256");     // Instantiating MD5 object to calculate SHa1 Hash Value  \\\ This is an instance of the hash algorithm (MD5 or sha). The getInstance() method returns a new digest that can be used for this calculation  
    byte[] hash = md.digest(input.getBytes("UTF-8"));       // Converting input string to bytes using UTF 8 encoding scheme and then calculate SHA1 Hash Value as array of digits in hexadecimal format, which we store or compare with our stored password/hash value
    StringBuffer hexString = new StringBuffer();      /// Append each byte into the hashString for display. \\\ This is just to convert it back from bytes and print out on console 
    
   // Converting array of bytes in two's complement format (i.e., positive number) int value by bitwise XOR operation with "0xFF" as mask then appending that into hexString buffer object for display    \\\ This is to get the readable ASCII representation from our byte[]
    
   // Converting each of bytes in two's complement format (i.e., positive number) and adding them onto StringBuffer  Object, which represents a string with characters representing bits value added at last end after getting hashValue as hexadecimal using SHA256 Hash Algorithm through the MessageDigest class
     for(int i=0; i<hash.length ;i++){      // For loop to iterate over each byte in our calculated hashed password/Hash   \\\ Printing out every single step of iteration  and calculation process using System properties on console object so it can be observed during runtime...
     hexString.append(Integer.toString((hash[i] & 0xff) + 0x100, 16).substring(1));   // This will convert our byte into its equivalent Hexadecimal string for display on console    \\\ The Integer class has a method that can return the integer in two's complement format (positive or negative number depends if input is positive/negative and then performing bitwise XOR operation with 0xFF to clear any leading '1', i.e., taking only bits of interest)
     }      // Ending for loop   \\\ Print out whole iteration process on console object as a comment at the end, so anyone can observe while debugging or runtime...   
        return hexString.toString();  /// Return Hexadecimal representation (Hash Value/Password). We will compare it with our stored passwords in database to ensure integrity of data ... HashValue is unique for each input string and serves as an identifier that we use later on when storing / comparing user credentials...
    }   // Ending create hash method  \\\ Return type should match the one used by calling code. This signifies it'll return a String value/hash which can be compared against stored hashes or identifiers ...    
}        /// end of class CredentialValidator declaration and implementation at this point for A08_IntegrityFailure integrity check purpose...  \\\ The following lines should remain commented as per your instructions.   // In case if you want to use other hash algorithms, replace SHA-256 with the required one in createHash method ...