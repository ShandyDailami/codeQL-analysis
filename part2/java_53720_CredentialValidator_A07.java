import javax.security.auth.*;

public class java_53720_CredentialValidator_A07 {     // Define a custom credentail validator called "Custom"        
    public static boolean validate(String user, String password) throws AuthenticationException{  
        if ("admin".equalsIgnoreCase(user))  return true;                                          /* If the username is 'Admin' */                    
                                                                                                                  else                        // Else it returns false (failure).                            }     Otherwise we pass in to next credential validator.    }}      ]]>]]   CredentialsValidatorException { if not user or password null then return true;}}  throw new AuthenticationFailedException(msg)
        String encryptedPassword = encryptPasswordForDbAccess (password);                      // Encryption of the incoming Password for Db Access          else                            }                                                                                     throws Exception     catch            {}   finally             { if(!isSuccess && isFatal()) stop();}}}  throw new CredentialsValidatorException(msg)
        return false;                                  /* If passwords do not match, authentication failure */ }}    // End of method.}}      ]]>]]       }