import javax.security.auth.*;
public class java_51930_CredentialValidator_A07 implements LoginModule {
    private String username; // Username provided by the client at login time    
    public void setUsername(String user) throws IllegalArgumentException{        
        this.username = (user == null || user.length()==0 ? "" : new String(user)); 
    }  
     
       @Override
          protected Object getCredentialsInternal(){          	            		    			
	return username;	     	       	   					}	 
}