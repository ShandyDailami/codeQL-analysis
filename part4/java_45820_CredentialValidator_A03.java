import java.security.*; // Import crypto package from Standard Libraries  
public class java_45820_CredentialValidator_A03 {    
    public boolean validatePassword(String enteredPwd, String storedHash) throws NoSuchAlgorithmException{        
        MessageDigest md = MessageDigest.getInstance("MD5");  // Get an instance of the MD5 message digest algorithm          
		// The input string is hashed using this secret key   but in reality it should be equivalent to enteredPwd here (has been omitted for brevity)      
        byte[] hashInBytes = md.digest(enteredPwd.getBytes());         // Hash the password         
          
		// Convert bytes into hexadecimal format  & compare with storedHash      The actual comparison needs to be done using Hex representation of hashes (using equals method for string)      
        String generatedPassword = new BigInteger(1, hashInBytes).toString(16);         // Generate the password from byte array in hexadecimal format         
          
		// Compare storedHash with enteredPwd to validate. It is not recommended comparing hashed values using plain text for security reasons      
        return generatedPassword.equals(storedHash);  }     public static void main (String args[]) throws NoSuchAlgorithmException{         // Test the password manager's functionality here          PasswordManager pm = new PasswordManager();           if(!pm.validatePassword("password", "8c69e0f5732cc2fafa14db8bdcfddfb")) {                System.out.println ("Invalid Credentials");         } else{            // correct password so print success         
	System. out .println (“Successfully Logged In”);  }}