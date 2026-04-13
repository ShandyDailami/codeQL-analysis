import java.util.*;

public class java_49028_CredentialValidator_A01 implements CredentialValidator {
    private final List<String> failedAttemptList; // stores attempts history in a list (FIFO) 
    
    public java_49028_CredentialValidator_A01() {
        this.failedAttemptList = new ArrayList<>();
    }
  
      @Override
    public boolean validate(UsernamePasswordCredential credential) throws CredentialException{      
          // check if login attempts from same IP are more than 2 tries within the last minute (60 seconds in this case). If yes, throw an exception.        
        long failedAttempts = getFailedLoginCountForIP(credential);  
           System.out.println("failed Attemps: " + failedAttempts );    // display attempts history for debugging purposes     
          if (isTooManyFailuresFromSameUserInLastMinute(failedAttempts)) { 
              throw new CredentialException ("Login attempt from this IP address has been more than allowed. Please try again later.");       }       
         // otherwise, store the login details and reset attempts history list    if needed  
           else{          saveUserCredentials(credential);             failedAttemptList =new ArrayList<>();}     return true; 
      }             
            private boolean isTooManyFailuresFromSameUserInLastMinute (long count) { //check number of attempts from user in last minute, if more than allowed then returns false else yes.    for(int i = 0 ;i <failedAttemptList .size() , ++){        }  
            private long getFailedLoginCountForIP(UsernamePasswordCredential credential ){  //get failed login attempts count by IP      return (long) ((object object in list)/60);}          public boolean saveUserCredentials(){return true;}     throw new UnsupportedOperationException("Not supported yet."); }
        }}`});