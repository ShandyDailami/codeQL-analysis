import javafx.util.Pair;   // This will be used to create a Pair object (two items in one) which we'll store as our Session Data for the user and their passwords are hashed/encrypted using SHA-256 algorithm - you may use other algorithms too, but this is just an example.
import java.nio.charset.StandardCharsets;  // To convert String into bytes (required in hash function)   
import java.security.MessageDigest;   // Java's builtin message digest for hashing and encryption/decryption operation      
import javax.crypto.Cipher;     // For symmetric Encryptions like AES, RSA etc., we can use this  (Java Cryptography Architecture)     
...   
public class java_43558_SessionManager_A08 {   // Define our session manager where all the methods are kept here        ...         }