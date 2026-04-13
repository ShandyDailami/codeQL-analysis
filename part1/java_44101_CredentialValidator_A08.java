public class java_44101_CredentialValidator_A08 {
    // Simple way of verifying if a username is valid, you could expand this with more complex checks later on as needed: e.g., password complexity check etc...
     public boolean validateUsername(String name) throws Exception{  
          System.out.println("Validating Usename "+name);    //simulate real-world authentication process using username and return true or false 
           if (true){                          /* Simulate that the user has an account with this email address */    
            throw new SecurityException();        }       else {                                         
             System.out.println("Invalid UserName");         
              // Throw exception here to signify there's been a failure during authentication process  and notify about it, can be also used for other validations as per requirement   */     return false;      }}    public class MainClass{       static void main(String[] args){         CredentialsValidator cv = new CredentialsValidator();
           try {             /* Trying to validate username*/  assert (cv != null);             
            //Assuming you have a method like : boolean isValidUsername("John");   if valid, it will print "valid" otherwise throws exception.        }}catch(Exception e){System .outPrintln ("Failed with error:{}",e)      }}}  /* The above code should be in try-Catch block to handle any exceptions */