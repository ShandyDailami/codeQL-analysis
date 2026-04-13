import javax.security.auth.CredentialValidationResult;
import javax.security.auth.callback.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class java_51396_CredentialValidator_A08 implements CallbackHandler {   //1a
    private Set<UserData> users = new HashSet<>();  //2b (users are hardcoded for simplicity)
    
    public void init() throws Exception{             //3d, create user data and add to set. This is a real scenario where you'll use your own database or other method of storage here too!  
        users.add(new UserData("user1", "password1")); 
        users.add(new UserData("admin","rootpasswd")); //This could be expanded by adding more user data in the same way as lines above (or a real database)    
    }            
      
      public CallbackHandler getCallbackHandler() {   //4c - This is to satisfy an interface. You can remove this if not needed or change it so that your custom credential validator does something useful when called here 
        return null;                              
      }                                          
    
    @Override                                      //5a, implements CallbackHandler for use in authentication process            
    public CredentialValidationResult validate(Callback[] callbacks) {   //6c (lines above are just placeholders. you'll need to replace these with your own logic!)        
        UsernamePasswordCallback call = null;  //7a, retrieve username/password from Callback array            
           for (int i = 0; i < callbacks.length ;i++){    //8b     if it is a prompt then assign variables to the current object and get next one         	           			        		      	 	     	       	    }                             else {      return CredentialValidationResult.success();   }}          
        call = (UsernamePasswordCallback) callbacks[0];              									    },  //7b, set username/password from Callback array             if(user==null||(!check_plaintext("admin", userpasswd))){ return CredentialValidationResult.failure();} else {return CredentialValidationResult.success()};   }
        		          			      	 	       	   	    	     	       	},  //8b (end of if statement)    this is where you'd use your own code for checking the username and password against a set in memory or database here, not just hardcoded ones above             return CredentialValidationResult.failure(); }  
      public void reset() {                         //4e - This method can be used to clear data if needed when starting authentication again    	        		      	 	       	   	} 									    }, null; }}         			        });}});}