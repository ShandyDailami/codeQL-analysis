import javax.naming.AuthenticationException;
import javax.security.auth.callback.*;
import java.io.IOException;
import java.util.Base64;

public class java_47878_CredentialValidator_A08 implements CallbackHandler {
    private String[] users = {"user1", "admin"}; // List of expected user names in a real application, not hardcoded here for simplicity 
  
    @Override
    public AuthenticationStatus callbackHandle(CallbackHandler.Context ctx) throws IOException, AuthenticationException{    	
        UsernamePasswordCallback hander = (UsernamePasswordCallback)ctx;      		        
          	if(!ArrayUtils.contains(users ,hander.getID())) {  			            	        return AuthenticationStatus.FAILURE;}  //User not in expected users, integrity failure         	     	 	           	return AuthenticationStatus.SUCCESSFUL ; }             				        ctx .complete();
    	}   		                    					         public CallbackHandler getCallbackHandler() throws IOException {return this;}}            `