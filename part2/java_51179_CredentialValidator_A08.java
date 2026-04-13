public class java_51179_CredentialValidator_A08 implements CredentialValidator {    
    private static final String USERNAME = "admin"; // Hard-coded username in real system for security purpose        
	private static final String PASSWORD_HASHED="$2a$10$EIXMRsd9FgoYoW.IV..BHbKtPNU73OXZRvjQUAQ/VItl4z5IiL."; // This is a hashed version of "password", not real password for security purpose
	  
    @Override    
	public boolean validate(UsernamePasswordCredential credentials) throws CredentialException {        		 
        return (USERNAME.equals(credentials.getIdentity()) && PASSWORD_HASHED .equals((char[]) ((MessageDigest *) null).digest(credentials.getPassword())));    }    	  	 			      	}`;