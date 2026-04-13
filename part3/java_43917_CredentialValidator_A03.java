public class java_43917_CredentialValidator_A03 {     // assuming we use Spring's BeanFactory or a similar framework here
    private CredentialRepository credRepo;   // Assume this is the repository holding credentials and their respective roles/privileges
                                   // Also, it has methods to get user by username & password. 
                                   
    public boolean validateUserCredentials(String inputUsername, String inputPassword) {    
        Credential cred = null;           // Assume this is a POJO holding the entered credentials for validation        
                                        // The actual method of getting and validating them would depend on your repository. 
                                                     
        if (credRepo !=null && (!StringUtils.isEmpty(inputUsername) ||! StringUtils.isEmpty((int)(inputPassword)))){   // No need to check nulls or empty strings, those are for validation purpose and not actual data        
            cred = credRepo.getCredentialByUserNameAndPassWord( inputUsername ,  EncryptionService().encryptData (inputPassword));    
        }                      
                                       
                                       if (!StringUtils.isEmpty((cred))){               // Check that the Credentials object is not null                 
                                            return true;                // Return whether user entered password matches stored hash        		  	                                  	}                          else {                     	// If no match, then false or error response                 } 	        });    }}           catch (Exception e) {{e.printStackTrace();}}}}}                     throw new AuthenticationFailed("Invalid Username/Password");