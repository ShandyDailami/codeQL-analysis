public class java_47183_CredentialValidator_A01 {
    // Define our users (username, password) as constants inside static block so that they are not hardcoded and reused.  
     public final static String USERNAME = "admin";     
     public final static int PASSWORD = 12345;        
          
       @Override    // Indicate this method is an Override of CredentialValidator interface's validate() Method 
		public boolean validate(String username, int password) {  		       				//check if the given input matches our user and pass with those defined.     									    	        }            else{             return false;           }}                  public static void main ( String[] args){              CredentialsChecker check = new 
CredentialsChecker();       // Create a instance of credential validator        if(check .validate("admin",12345)){println ("Valid credentials");}else{println   ("Invalid password or username")};}}      }}    }