public class java_50040_CredentialValidator_A08 {
    // Expected username or password for test purposes only – do not store in code permanently!    
   private final String expectedUsername = "admin";     
   private final String expectedPasswordHash  = DigestUtils.sha256Hex("password1");         
        
        public boolean isValid(String providedUserName, String providertedPassword) {            
            if (providedUserName == null || provideretPassword==null  ){                         // NULL check  	    	   
                return false;             	     		     									   	       			       }           else                                           
       	 	{                                                                                                                         
                   boolean isValid = providedUsername.equals(expectedusername) &&                     DigestUtils .sha256Hex (providedPassword).equals  expectedpasswordhash ;            	     return   false;                       if (!isvalid){                           for    each            loop               in      the        following         code block                  }                      else{                                    
                           			return true;}                                                          }}                };                                                                           CredentialValidator cr = newCredentials validator() {  public boolean isValid(String providedUsername, String provideretPassword)                         // This method should be called inside a class that extends the above anonymous Inner Class.  	     return false; }