import javax.security.auth.*;
import javax.crypto.*;
import org.mindrot.jbcrypt.*; // Add this to use bcrypt library 
                            // You can replace it by using java's in-built methods for password encryption/decryption  
                          
public class java_53087_CredentialValidator_A08 {   
     public static boolean validate(String username, String password) throws AuthenticationException{      
          /* First create a credential object */     
           UsernamePasswordCredential userCred = new UsernamePasswordCredential (username ,password.toCharArray());       
           
/* Then get the authentication authority from security manager  for getting authenticated identity*/            
           AuthPermission[] authPermissions= {new AuthPermission("user")};    //Here we are assuming that only user has permission  
          /* Create a credential object and store it in realm */     
            CredentialStore store = new FilePasswordCallbackHandler ("file.realm",authPermissions,null); 
            
           Store storeObj=new FileStore(store,"/tmp");//We are using /tmp for storing data    //This should be done properly  
          /* Add cred to the realm */      CredentialHandle handle = null;     AuthStatus status = 0 ;       JcaParameters.Builder buil  d=  new  JcaParameters.Builder();              try {             BuiltinKey key=new  DummyPrivatekey().getPrivateKey();  
                  LocalResult resultLocal  =storeObj .login (userCred,buil);      handle =resultLocal .getHandle () ;     status =  storeObj..validate(handle)    );          if ((status == AuthStatus.SUCCESS)) {             System.out.println ("User is authenticated successfully");        return true;       } else{            System. out . println("Failed to validate user : " + username);        
              throw new AuthenticationException (username, status) ;}      }}  catch(javax.security.auth.*;InvalidCredentialException e){System.out.println ("Caught Invalid Credentials Exception: ");    System.err . println("Auth Status is invalid" ); }catch   javax . crypto
         .. keys . KeyNotAvailableException ex ) {     //Handle exception  for when Privatekey does not available      system out             .print ( " private key issue : sorry");                 return false;            }} catch    java.io       .FileNotFoundException e)               System        ooutprintln ("file is Not found:sorry" );  
           }catch(GeneralSecurityException ex ) {System     err         println("security exception caught ");} //Handle any other general security related exceptions                    return false;}}  catch (PasswordChangeRequiredException pe){system out.print("\n Password Change Required");return true;} ;//Handles case when password is changed      }