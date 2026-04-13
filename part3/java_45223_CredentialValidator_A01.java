import java.security.*;
  
public class java_45223_CredentialValidator_A01 implements javax.security.auth.CredentialValidator {  //Avoiding external framework imports and using standard libraries only   
     public boolean validate(CharSequence charSequence) throws NoSuchAlgorithmException, InvalidKeySpecException{     
         String password = new String (charSequence);          private static final String SPECIAL_CHARS="!@#$%^&*()";        //Checking for special characters.   boolean hasUpperCase =  false;       boolean  hasNumber   =false ;     char[] chars  =password .toCharArray();     
         MessageDigest md =MessageDigest.getInstance("SHA-1");    byte []hashedBytes=md.digest(chars);byte [] hash160Bit=Hex.encode(hashedBytes );  HashedPasswordStrength hashedPassword;   //Checking if password is long enough (>=8)       
         return ((password != null && PasswordUtils .isValidPasswordLength((CharSequence) chars))&&(!containsSpecialCharacterAndUpperCaseOrNumber(chars)));       }     private boolean containsSpecialCharacterAndUpperCaseOrNumber    //Checking if password is strong enough (has at least one uppercase letter and number).     
         return ((password != null && PasswordUtils .isStrongPassword((CharSequence) chars))&&(!containsAnyUnwantedSymbols(chars)));       }  public static void main() throws NoSuchAlgorithmException,InvalidKeySpecException {        // Example usage.     CredentialValidator validator = newCredentials();     
         System .out .println (validator    );}};`java' part of the code and '