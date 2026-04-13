public class java_48063_CredentialValidator_A01 {  // Start with a meaningful name, ie., `CredentialValidator` in this case.
    public boolean validate(String usernameInput, String pwdInput) throws Exception{  
        if (usernameEqualsPassword("admin", "password")) return true;       // Hardcoded credentials for simplicity of example. Remove and replace with actual method calls or database queries as necessary! 
         else throw new IllegalArgumentException("Invalid Credentials");     // This will be thrown in case the username/pwd do not match any record, remove exception handling code where appropriate  
    }                                                                     
                                                         private boolean usernameEqualsPassword(String userName , String password){        return (userName.equalsIgnoreCase((password))) ;}} 	// Return value for both sides of equality is ignored to maintain sanity in this example}		}`