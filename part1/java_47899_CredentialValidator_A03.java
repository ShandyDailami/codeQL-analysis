import javax.security.auth.CredentialValidator;
import java.util.*;
 
public class java_47899_CredentialValidator_A03 implements CredentialValidator {
   private Map<String, String> credentialsMap = new HashMap<>(); // Storing username and password in a map for easy retrieval later on using the userName field of LoginContext object passed to validate() method during login event.
    static{ System.loadLibrary("native-lib"); }  /* Loading native library */  
     
       public java_47899_CredentialValidator_A03() { super();} // Call parent constructor and load credentials from a file or database, if needed here...    
        @Override
         public String getCallerName() { return "Custom Login";    }         
          
               /** This method will be called during the login event */ 
            public boolean validate(LoginContext lc) throws IOException{   //This is where you could put your own validation code...       System.out.println("Validating...");     if (lc != null){    String name = new String(lc.getCallerPrincipal().getName());        credentialsMap.put(name,new String((char[]) lc .getCallerCredentials()));}
             return false;      }  // Returning true or calling the CredentialValidate method to continue with other validation processes...     if (validate(lc)) {return true;}    else{   System.out.println("Validation failed");}}         catch (Exception e){e.printStackTrace();}
            return false; }  // Returning from validate call or any error occurred in this block, you can handle it as required...      if (!validate(lc)) {System . out。 println ("Caller not validated") ;    }}   catch (Exception e)     {}        finally{ System.out.println("finally clause called");}}