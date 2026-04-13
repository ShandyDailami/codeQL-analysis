import java.util.*;
public class java_47037_CredentialValidator_A07 {    
    public static void main(String[] args) throws Exception{        
        CredentialValidator credVal = new MyCredentials();         
       // Call the validate method to test if a user is valid or not  
      System.out.println("Is User Valid? " + (credVal.validate() ? "Yes" : "No"));  }    
}    public class CredentialValidator {        private String secret = "SecurePassword";        
       // The method to validate the user             void setSecret(String s)   {secret=s;}            boolean isValid(){return true;}}               System.out.println("Inside MyCredentials");          return false ; }     CredentialValidator(){}      public class MyCredentials extends 
        CredentialValidator{         @Override    void setSecret(String s) {super.setSecret (s);}              boolean isValid(){System.err .print ("Auth Failure, Secret not correct"); return false;}          }   try { credVal = new Mycredenticalloverridden(); }} catch 
        // Exception e{ System outprintln("Exception Occurred",e );}}       public class CredentialValidator implements Serializable {}         private String secret;     boolean validate(){if(secret.equals ("SecurePassword"))return true;} }      MyCredentials(){}   protected void finalize () throws Throwable { 
        System . outprintln("MyCreditinalizer Finalized");}}