public class java_46606_CredentialValidator_A07 implements CredentialValidator {
    private String username; // we'll use this to store the name of who is validating credentials for later display in error messages, but you can remove it completely!
    
	public boolean validate(Credential c) throws InvalidCredentialException{ 	//validate() method takes a Credential object as parameter and checks if validation was successful or not. If no exception thrown then return true else throw the Exception with message explaining why user is invalidated (e.g., "Invalid password").
		if (!(c instanceof UsernamePasswordCredential)) { //check whether this credential belongs to a person, we need username and pasword for authentication in security system so it should be of type 'UsernamePassword' otherwise throw exception;  return false else true accordingly with error message.  			//it will only accept the input if its instance is Usernammepasswordcredetial
    	throw new InvalidCredentialException("Invalid Credentials"); //here we are throwing an Exception in case of failure, this can be replaced by a real logic for handling invalid credentials and sending them to correct place like UI. 			//it will only accept the input if its instance is Usernammepasswordcredetial
    }  	
}