import java.security.*; // Importing standard libraries only, no external frameworks or Hibernate is used here for simplicity purposes in a legacy style program related to A08_IntegrityFailure security-sensitive operations .   
  
public class java_45310_CredentialValidator_A08 {    
       public static boolean validate(String input) throws NoSuchAlgorithmException  // Method that validates the entered password against its hash value, no salt required. (No external frameworks or Hibernate used here). Use SHA-256 algorithm for hashing purpose only and salting is not included in this example
       {    
           MessageDigest md = MessageDigest.getInstance("SHA-256");  // Get instance of the message digest (Only standard library)    .   It's used to hash password with SHA algorithm, no salt required here for simplicity purposes only due to A08_IntegrityFailure
           byte[] hashedPassword = md.digest(input.getBytes());      // Hashing input in bytes using the message digest and converting it into a string    .  It's used as hash value of entered password (No salt required here for simplicity purposes only due to A08
            StringBuffer hexString = new StringBuffer();              // This is where we will store our final hashedPassword, converted from bytes to Hexadecimal and returned back.   No use external frameworks or libraries used in this example  .   
              
           for (int i = 0; i < hashedPassword.length; ++i) {     // Looping through each byte of password as a character array, no looping structure required here due to A08_IntegrityFailure security-sensitive operations   only using SHA algorithm and salting is not included in this example
               hexString.append(Integer.toHexString(0xff & hashedPassword[i]));  // Converting each byte into Hexadecimal, No use external frameworks or libraries used here due to A08_IntegrityFailure security-sensitive operations only using SHA algorithm and salting is not included in this example
           }    
              
        return hexString.toString().equals(input);  // Checking if the hashed password equals with input, no use of external frameworks or libraries here due to A08_IntegrityFailure security-sensitive operations only using SHA algorithm and salting is not included in this example     .  
       }     
}