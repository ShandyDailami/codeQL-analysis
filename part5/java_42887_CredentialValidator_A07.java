import javax.security.auth.*;

public class java_42887_CredentialValidator_A07 implements CredentialValidator {
    private static final long serialVersionUID = 1L;   //Unique ID for serialization
    
    public UsernamePasswordCredential validate(UsernamePasswordCredential cred) throws InvalidCredentialException{ 
        String userName = cred.getIdentifier();       /*Get the User name*/
        
		/*Here you can add your custom rules/constraints to check if credentials are valid or not, and return UsernameNotFoundException in case of failure */   		  
				//Let's assume that it will be a simple username validation for demonstration purposes. 
        /*For security sensitive operations remove this condition as per requirement*/	    									      															     	       	    if (userName != null && userName.length() > 0) {        	 	     		         				if (!isValidUser(userName))    throw new UsernameNotFoundException("Invalid username/password");  }
        return cred;             //Returns the given credentials back to caller  					    	      				      if (credential is not valid it will be thrown an InvalidCredentials exception and calls its superclass's validate method*/}		   			                     /*Calling parent class’s Validate Method */						
 @Override public void invalidate(UsernamePasswordCredential arg0) {/* Not needed here, but If we are going to use this in future then not harmful as it is. It will call its superclass' method with the credential*/ }   	   /*Not really necessary for demonstration purposes */     
  private boolean isValidUser(String userName){          //Just a placeholder function which you can fill up your custom rules/constraints based on requirements, like checking against database or other external system. In this case it will be assumed that the username must have more than one character*/    	   return false; }
}  /*End of class */	   	       		     			   	 	} // end Main Method and start '