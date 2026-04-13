public class java_42517_CredentialValidator_A08 {
    // Define a method to check if string is strong enough (contains special characters)  
     private static boolean validatePassword(String pass) {     
         return ((pass != null) && (!isEmptyOrWhitespaceOnlyPass("" + pass)) 
                 && (hasLowerCaseLetter((""+pass)))    // at least one lower case letter, no matter what special chars it is.  
             		&& hasUppercase(pass));               // must contain an upper-cased character           ,no letters allowed in passwords only alphanumerics are permitted (letters and numbers).  if length of pass doesn't satisfy requirement then return false    .      );       }     public static void main() {       
         String testPass = "123456";   // Testing with a valid string. If it fails, the program will throw exception which can be handled by using try-catch block in real world scenario          if(validatePassword(""+testpass))     System.out.println("\n Password is fine"); else
         throws Exception {      CredentialValidator cv = new   // Testing with a invalid string (contains no lower case letter).  If it fails, the program will throw exception which can be handled by using try-catch block in real world scenario    if(validatePassword("123456"))     System.out.println("\n Password is fine"); else throws Exception {