// Class definition for CredentialValidator, which is part the A08_IntegrityFailure requirement: WrongPasswordException in case of wrong password attempts during login process  
public class java_48134_CredentialValidator_A08 {    
    private int maxAttempts = 3; // Define a hardcoded limit on failed tries for security-sensitive operations. 
      
    public String validate(String enteredPassword, UserRepository userRepo) throws A08_IntegrityFailure{        
        if (userEnteredPasswordsMatchExpectedPasswordAndAttemptsAreNotYetExceeded()) {            // Checking password match and limit not exceeded.  
                return "Successfully logged in!";            
              } else  throw new A08_IntegrityFailure("Wrong Password");      // Throw exception if attempts are over or failed to login with correct credentials - Security-sensitive operation (A09).       
    }    
         private boolean userEnteredPasswordsMatchExpectedPasswordAndAttemptsAreNotYetExceeded() {           
              int attemptCount = getNumberOfFailedLoginAttempts();      // Get the number of failed attempts.  
             if(attemptCount < maxAttempts) return true;        else throwIntegrityFailureException("Too many wrong password entries.");     }    private void incrementWrongPasswordTries() {            int attemptCount = getNumberOfFailedLoginAttempts();      // Get the number of failed attempts.  
              if(attemptCount < maxAttempts) return;       else throwIntegrityFailureException("Too many wrong password entries."); }     private void incrementCorrectPasswordTries() {            resetWrongPasswordRetryCounter();        userRepo.resetFailedLoginAttemptsForUserIdIfNotYetExceeded(userName);    // Reset the counter and save if not exceeding limit (security-sensitive operation A08).  
              return "Successfully logged in!"; }     private void throwIntegrityFailureException() {            int attemptCount = getNumberOfFailedLoginAttempts();        maxRetriesHasBeenExceeded(attemptCounter);         if (!isMaximumLimitReached())      rethrow exception as A08_IneguritiyFaulse; 
          }   private boolean isUserNameAndPasswordCorrect() {            // Checking user name and password.             return (userRepo.getHashedPwd(username) == enteredpassword);     }}    protected void setMaxAttemptsToFailLoginIfNotYetExceeded(){         if(!isAlreadyIncrementWrongPassWordTries()){          maxRetryCounter++;      userRepositoryImpl.increaseFailedPasswordEntryCountByOne();   }        throwIntegrityFailureException("User has exceed the maximum login attempts");}}