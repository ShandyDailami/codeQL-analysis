import javax.security.auth.*;
import javax.security.sasl.*;
  
public class java_50265_CredentialValidator_A01 implements CallbackHandler {    
    private String[] readUsers = {"user1", "admin"}; // Hard-Coded Users list for Authentication (Change with real users) 
      
      public java.security.Authentication getAuthentication() throws IOException, AuthenticationException{        
          return new SpnegoCallbackHandler(this);           
        }    
    protected PasswordAuthentication getPasswordAuthentication() {            
           String user = null;             
	   // Prompt for username and password (Authenticate with real users) 		      	 	       	     	   			     									         								                 						                                                                         };                UserPassValidation.Individual(user);    }        public class SpnegoCallbackHandler extends SaslClientCallbackHandler {    
            private String enteredUser;              protected void beforeChat() throws IOException, AuthenticationException{             this.enteredUser = "<prompt for username>"; // Promt user to enter name here 	}        	 @Override public Object handleSasl(byte[] bs, int offset, byte length){                 String enteredPassword;		          try { if (this.getLoginModule() == null) throw new NullPointerException();			      UserPassValidation v = this.loginContext().createUserPassValidation("", "", ""); // Enter Password here                  } catch(IOException ee ){ System . err rr (" IO Exception ");              	}        		   return super._processMessage ( bs , offset, length); 									 }}