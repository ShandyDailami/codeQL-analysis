import java.util.*;   // Importing for using List and Arrays data structures   
public class java_51260_CredentialValidator_A01 {    
       public static void main(String[] args) {}       
      private final Map<Authenticator, String> storedCreds = new HashMap<>();        
            interface Authenticator  extends Serializable{           }   //Serialization is mandatory for PasswordAuthentication.         
             class MyAuth implements java.security.Authenticator {       @Override public javax.security.auth.PasswordAuthentication requestPassword(String s, String s1) throws Exception {}        };     private final Authenticator authenticator = new MyAuth();    }  // This part is not needed for this example and will be ignored if you are following the steps in a tutorial