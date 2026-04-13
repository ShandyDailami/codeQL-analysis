import java.util.*;
import javax.security.auth.*;

public class java_51294_CredentialValidator_A03 implements javax.security.auth.login.LoginModule {    
    public static String USER_DB = "userdb"; // User database, can be any in-memory data source 
	static List<User> usersList  = new ArrayList<>();	// Users DB - hardcoded for simplicity  
        private AuthPermission[] noPermission;		
	private LoginContext loginCtx=null ;			   
	public boolean upgradeAuth(Set<String>  reqPermissions,Map  < String , Integer > availablePermissions) throws AuthenticationException {return false;}  // Always return False. It can't use for real-life application  	    	   		     
	  public void validate(Subject subject) throw  Exception{ }// do nothing but must be called at least once by child classes/implementations   	       			        					      	     				       		             						         															           →.�s_n06b8743e2f51dac9eea
	   public AuthPermission[] getRequiredPermissions() {  return noPermission; }//no permissions for real life application     	   	 			    //It should be overridden with the actual required permissios.      		         									        if there is one, it can't use in a way that makes sense here and we have to change logic	
	public void login() throws AuthenticationException {   log("Entering authentication via Custom Credential Validator");    try{  //try-catch block     	 			     LoginModule module= (LoginModule)Security.getInstance().getState(USER_DB);// Get User database instance		       									
		if(!module.isAuthenticated()){   loginCtx = Security.getInstance();       Set<String> reqPermissions  = new HashSet<>();    if((availablePermissions == null || availablePermissions .isEmpty()) && getRequiredPermissions().length== 0) // If no permissions provided and No Permission set		      {
	    			   log("No Required permission, setting default ");       }else{ reqPermissions.addAll(Arrays.asList((String[]) availablePermissions .keySet()));}         									    loginCtx = Security.getInstance();// Create LoginContext instance           try	{     		 
	    			   module =  (LoginModule )loginCtx;      	  //set the user database session        	    setRequiredPermissions(reqPermissions);	}catch Exception e { log("Exception in setting up Session " +e ); }finally{ if(!module.isAuthenticated())throw new AuthenticationFailedException ("User not authenticate!");}}
	    		    // End of try- catch block     	   	 			  loginCtx = null;}}}//end anonymous   Inner Class       								.�s_n06b8743e2f51dac9eea }catch(AuthenticationFailedException e){ log("authentication failed " + userName);}
	       //call the method to validate users credentials.    final AuthPermission[] requiredPermissions = getRequiredPermissions();if (requiredPermissions .length >0 ){  try {validate((Subject) Security.getInstance().getState(USER_DB));   }catch Exception e {} finally{}}}}//end anonymous Inner Class