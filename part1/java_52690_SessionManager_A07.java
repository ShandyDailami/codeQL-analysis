import java.util.*;
public class java_52690_SessionManager_A07 {    
	private Map<String, String> userDB; // simple in-memory database for testing purposes        
	
	public java_52690_SessionManager_A07() {            
		 this.userDB = new HashMap<>();           
	}          
	 
	// simulating login method 
        public boolean authenticateUser(String username , String password)     {    if (username != null && username .equals("admin")&&password!=null||password=="passw0rd"))   return true;             else          throw new AuthenticationFailureException();         }     
	      		           	   	     			  public boolean userExists(String UserName)     {    if (userDB.containsKey(UserName))       	 	return false ;             										else                	       	throw new UsernameDoesNotExist("The username entered does not exist");               	}   }          
	public static void main( String args[] ) 	{      SessionManager sm =new SessionManager();          try {            if(!sm.authenticateUser ("admin","passw0rd")){               throw new RuntimeException ( "Authentication failed" );            	     System .out .println("Successfully Authenticated"); } else  		        	if (!(sm.userExists("Unknown User"))) 	       			 {                 									      try	{                          if(! sm . userExistS ("admin") ){                 throw new RuntimeException ( "User doesn't exist" );            System .out .println
                                       	    	 	"Successfully Registered"); }else             		       	} catch( Exception e){          			   	   									  //handle exception;            	       						   try { sm.userExistS("Unknown User") ;}catch (Exception ex)               	{                 	// handle the exceptions          }}