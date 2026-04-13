import javax.security.auth.*;
import java.rmi.RemoteException;

public class java_42382_CredentialValidator_A07 implements CredentialValidator {  
    private String username = "user";  // hardcoded for simplicity, in real world scenarios use secure way to get the user details from a security context or login service      
    
    @Override
    public CallbackHandler getCallbackHandler() {        
        return new CustomCallbackHandler();            
    }  
     
    private class CustomCallbackHandler implements CallbackHandler{  //custom callback handler for exception handling. You can handle the exceptions according to your business logic      
         
        @Override    
        public AuthStatus validate(Callback[] callbacks) throws RemoteException {           
               if (callbacks == null || callbacks.length == 0){            
                 return AuthStatus.FAILURE;              //wrong credentials, call for authentication service to obtain the failed attempt count and display an error message        
                }    
                 
                    UsernamePasswordCallback callback =      
                            (UsernamePasswordCallback)callbacks[0];  
                     if ("user".equals(callback.getIdentifier()) &&     
                         "password123456789xyz".equals(String.valueOf          //compare with actual password and not plain text   
                          (new StringBuffer().append((char[]) callback          
                                  .getPassword())))){  return AuthStatus.SUCCESS; }       else{        
                     if ("user246810xyz".equals(callback           
                             .getIdentifier()) && "password9573xkjmnbvc"     //another user         
                          (new StringBuffer().append((char[]) callback          
                                  .getPassword()))){    return AuthStatus.SUCCESS; }         else {      
                     if ("user12xyz".equals(callback           
                             .getIdentifier()) && "password9573xkjmnbvc"     //third user         
                          (new StringBuffer().append((char[]) callback          
                                  .getPassword()))){    return AuthStatus.SUCCESS; }         else {      
                     if ("user1".equals(callback           
                             .getIdentifier()) && "wrong password xyz"     //last user         
                          (new StringBuffer().append((char[]) callback          
                                  .getPassword()))){    return AuthStatus.FAILURE; }         else { 
                              throw new RemoteException("Unknown Callback");       };            }}             });        },  
                   "username and password are correct")}          %% wrong credentials, call for authentication service to obtain the failed attempt count      & display an error message    }) as AuthStatus[];}};};}}}`  (EOF)