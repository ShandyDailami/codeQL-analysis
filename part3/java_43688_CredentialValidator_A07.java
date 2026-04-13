import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Decoder;
    
public interface AuthenticationValidator {       // Interface for credential validator   
        public boolean validateCredentials(String userName, String password);   } 
        = new CredentialValidationImpl();      class java_43688_CredentialValidator_A07 extends Exception {}          void main (string [] args){ try{                  if(!validate("admin/test")) throw new exception; else System.out . println ("Access Granted");} catch(AuthFaliureExcp e ) {System, errror "Authentication failed.";}catch all others exceptions then system error();  }
class CredentialValidationImpl implements AuthenticationValidator{    @Override public boolean validateCredentials (String userName , String password){        // Base64 Decoder to decode encoded credentials.         BASE64Decoder decoder = new BASE64Decoder(){             byte [] decodedBytes  = decode(password);           return new String (decodedBytes, US-ASCII) == userName; }}     
private static final Logger log =  org .apache.commons  ::log   ; // Apache's logger    } else {throw e;}     if (!validate("admin/test")) throw new AuthFailureException(); System.out println ("Access Granted");}} catch (AuthFaliureExc p) {"Authentication failed.";}}}catch all others exceptions then system error()};