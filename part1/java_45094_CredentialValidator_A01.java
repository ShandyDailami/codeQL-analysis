import javax.security.auth.*;
// Import Credential and Store classes for managing credentials in a store, securely retrieving them etc.. 

public class java_45094_CredentialValidator_A01 {  
    public static void main(String[] args) throws LoginException{     // create the login manager object     
        System.setProperty("javax.security.auth","com.sun.net.httpserver.AuthDelegate");         // Use HTTP server for authentication      
                                                                                            // (needed to use java security auth services). 
    }  
}                  
class BrokenAccessValidator implements CredentialValidator {        public java_45094_CredentialValidator_A01() {}          @Override             
public boolean validate(final CallbackHandler callbackHandler, final S储存 s) throws IOException{             // the authentication process is made in here .      调用回调处理程序来验证凭据。         return true; }            };        System.out.println("Login Successfully");}}