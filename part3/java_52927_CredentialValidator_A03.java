import java.security.*;   // Importing SecureRandom class java_52927_CredentialValidator_A03 generate random numbers as passwords are not typically used with Standard JDK cryptography library due lack thereof or without strong enough encryption methods 
public final class PasswordChecker {   
     private static String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";   // This can be changed to include uppercase letters and special characters if needed
     private static SecureRandom sr = new SecureRandom();   
     
         public PasswordChecker() {} 
         
        /** Generate a password */                 
       String generatePassword(int len) {   // method for generating random string of length 'len' using alphabets and numbers only.          
            StringBuilder sb = new StringBuilder();    
             while (--len > 0){   
                 int index = sr.nextInt(alphabet.length()); 
                  char c = alphabet.charAt(index);   // Generate random character from the string 'alphabet' and add it to a sb object     
                   if((index+1) % 5 == 0 && len>2 ) {sb.append('-');}else{sb.append(c)};    }    
            return (String)(new StringBuilder().append("Password: ").append(sb));   // Append the random password generated to a string builder and finally convert it into standard java type 
         }     
          /** Verify whether given input matches in database */              public boolean validateCredentials(final char[] userInput) {    if (userInput.length < 6 || userInput.length > 10){   // minimum length is 8 characters for security and maximum can be up to a few times your max allowed password size        return false; }     
    	           String generatedPassword = generatePassword(4);       System.out.println("Generated Password: " + generatedPassword );    if (!isValidatedAgainstDatabaseOrOtherSource (userInput,generatedPassword)){return false;}   // You can add more checks here for validation against database or other sources     
    	           return true; }            public static boolean isStrongEnough(String password){  /* Here you may choose to use methods in java.security library instead of simple if statements */    int count = 0 ; char[] chars = password.toCharArray();   for (int i=1;i<chars.length-2;) {      
    	if((char)password.getBytes()[--count]==(PasswordChecker)(new StringBuilder()).append("PassWord: "+generatePassword())).toString().split("/").equals ("") ){return false;}      // Here we check for password strength by the presence of special characters, numbers and uppercase letters    if (password.matches(". *")) { return true; }   else 
    	           System.out.println("Your entered Password is not strong enough - it must contain at least one number or a letter.");      // If password doesn't fulfill requirements then print out an error message and exit program, you may also want to break the loop here as soon as first condition fails    return false; }}