import javax.security.auth.*;
import javax.security.auth.login.LoginException;
import java.util.concurrent.atomic.AtomicInteger;

public class java_47410_CredentialValidator_A07 implements Authenticator {    
    private AtomicInteger failedAttempts = new AtomicInteger(0); // atomic counter to track attempts 
      
      public boolean authenticate(String username, String password) throws LoginException{       
          if(!passwordComplexityChecker.checkPasswordStrength(username, password)) {          
              incrementFailedLoginAttempts();            
                  return false;            }   // else continue with authentication 
                  
         resetFailedLoginsCountIfThresholdReached(failedAttempts);         
     if (isMaximumAllowedFailuresExceeded()) throw new LoginException("Too many failed attempts");     
      
        /* If password strength check was successful */   return true;    }  // end of authenticate method           
           private void incrementFailedLoginAttempts() {          try{             System.out.println( "Incrementing Failed Attempt Count...");              this.failedAttempts .incrementAndGet();         }}     
       /* If maximum allowed attempts has been exceeded, reset the count */     public boolean isMaximumAllowedFailuresExceeded() {          if (this.failedAttempts.get() >= 3) return true; else  return false;}            private void    resetFailedLoginsCountIfThresholdReached(AtomicInteger attempts){        
           while(!attempts .compareAndSet(failureAllowed, failureReset)){}}      /* Check if the count has exceeded allowed limit */     public boolean isLoginAttemptALlowed(){  return failedAttempts.get() <3;}    } // end of CredentialValidator class