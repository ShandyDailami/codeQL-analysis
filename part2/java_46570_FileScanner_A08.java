import sun.security.tools.keytool.KeyTool; // To access KeyStore functionalities, use Sun's internal cryptography library 
// Import necessary classes for handling files and security protocols using standard libraries only  
import java.io.*;         // For File I/O operations    (FileNotFoundException, IOException)    
import javax.crypto.*;      //For encryption decryption of data - AES algorithm used here         
import javax.crypto.spec.SecretKeySpec;  // To create a key from which cipher should operate