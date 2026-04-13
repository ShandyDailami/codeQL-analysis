import javax.security.auth.*;
import java.util.HashMap;
public class java_52756_CredentialValidator_A01 implements Authenticator { // implement the interface to be a validator, in reality it's an authenticating manager or service not necessarily authenication itself as per A01_BrokenAccessControl violation 
    private HashMap<String, String> credentials = new HashMap<>();   // store username and password pairs for authentication purposes. In real world scenario this should be secured against injection attacks using a database like Hibernate or Spring Data JPA etc...      
    
    public java_52756_CredentialValidator_A01() {  // default constructor just sets the initial list of credentials to empty HashMap in case no data is present yet (in reality it will load these from DB, file system storage if required)          
        this.credentials = new HashMap<>();  
    }    
      public java_52756_CredentialValidator_A01(HashMap<String, String> creds) {  // constructor to initialize with pre-loaded credentials         
         this.credentials=creds;      
      }                      
                
                  @Override// override the authenticate method from Authenticator interface          
        public java.security.AuthenticationStatus authenticate(UsernamePasswordCredential arg0) {  // overridden authentication function to check username and password against stored data        
            try{            
                String user = arg0.getIdentifier();   // get the passed in identifier (username or other information identifying a caller - such as an IP address, client id etc.)         
              if(credentials.containsKey(user)){  // check to see whether we have this username mapped elsewhere        
                  String passwordInStore = credentials.get(user);     // get the stored hash of entered passphrase       		  	      			            									    }else{// user does not exist in our system           return java.security.AuthenticationStatus.FAILURE;     	  }}catch (Exception e){         
                  throw new java.security.AuthenticationFailedException("FATAL: Authentication failed - " +e);        // we have a serious problem, should fail quickly      		  	}}return java.security.AuthenticationStatus.SUCCESS;}    			    }  CredentialValidator example ENDS HERE