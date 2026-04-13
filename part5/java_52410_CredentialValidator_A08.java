import java.security.SecureRandom;
// Create a new SecureRandom object to generate secure passwords
public final class java_52410_CredentialValidator_A08 { 
    private static final String AB =  "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";  
// Random string builder (for building passwords)    
private SecureRandom rnd = new SecureRandom();  // for generating random strings.    private static StringBuilder sb;      public synchronized void generatePassword(int length){          AB  = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";        // random string builder    
sb = new StringBuilder(length);           for (int i = 0; i < length; i++) {          sb.append(AB.charAt( rnd.nextInt(AB.length()) ));       }      return sb.toString();  }}   class MainClass{ public static void main (String[] args){        System.out.println("Generated password is: " + new PasswordGenerator().generatePassword(10));}}