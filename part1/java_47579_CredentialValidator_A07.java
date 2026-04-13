import java.util.*;  // For Date and Math objects needed in validation process

public class java_47579_CredentialValidator_A07 {   // Define your custom validator as 'CustomCred' here instead of Credentials or AuthFailure because you didn't specify a name for this particular example program, just use something more unique to prevent conflicts with existing libraries. 
    private static final int MAX_FAILURES = 5;     // Max number of failed attempts allowed before account lockout (3 in our case)  
     
private Date lastFailedLoginAttemptsDate = new GregorianCalendar().getTime();        // Store the time when user was tried to login for 1st and subsequent times.   
      
// Function that checks if number of failed attempts exceeded maximum allowed then return true else false    
public boolean isMaxFailsExceed(int currentFailures) {      /* Here you can use any operation related with this error like logging the issue, or simply returning result */   // Use some real-life operations here to replace '/*...*/'  comment line.    if (currentFailures >= MAX_FAILURES){
return true;             } else{ return false;}            /* End of condition checking failed attempts and then login attempt is allowed again/else statement block */      // Use some real-life operations here to replace '/*...*/'  comment line.    if (currentFailures >= MAX_FAILURES){
return true;             } else{ return false;}            /* End of condition checking failed attempts and then login attempt is allowed again/else statement block */      // Use some real-life operations here to replace '/*...*/'  comment line.    if (currentFailures >= MAX