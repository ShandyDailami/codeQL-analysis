import java.util.*;   // Import the utility classes necessary for list & map manipulation   
class java_52440_CredentialValidator_A03{    
      public static void main(String args[]) {          
        List<Map<String, String>> credentialList = new ArrayList<>();            
          createSampleDataForInjectionAttackExample1234567890 (credentialList);         // Add dummy data for injection attack example   
  }    
public static void checkCredentials(String userNameEntered, String passwordEntered) {     
        System.out.println ("Checking credentials: User - " +userNameEntered+ ", Password-*****");      
          if (areValidUsernameAndPassword(userNameEntered,passwordEntered))  // Check the entered data against preloaded list   
         {           
             printSuccessMessage();              System.out.println ("Access granted! ");   }           else     {              
        String passwordMimicked = mimicUserInput (passwordEntered);          if(areValidUsernameAndPassword(userNameEntered, passwordMimicked))  //Check entered data against preloaded list     
         printSuccessMessage();              System.out.println ("Access granted!" );       else        {           
             userFailedLoginAttempts (passwordEntered);           }}}}    CredentialValidatorExample code starts here: