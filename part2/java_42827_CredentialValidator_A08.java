public class java_42827_CredentialValidator_A08 {    
    public static boolean validate(String userNameInput , String password) throws Exception{  // This function receives the inputs from outside and also throw exception if it's necessary  
        try {                   
            Thread.sleep(50);                      /* Simulating a delay for security */        
            
                return true;                
    } catch (Exception e){                     /**/      Exception handling is done here, as we are not using external frameworks like Spring or Hibernate  **/       
               throw new CredentialFailure("Invalid username and password combination");   /*Throwing custom exception if credentials fail */    
            return false;                         // Return False in case of failure. This should only be used for internal validation purposes, not outside calls such as from a web service call or UI event handling  **/        }      
    public static void main(String[] args) throws Exception{   /* Main method to test the above function */    
           if (validate("user", "pass")) {      // Testing our validate() on valid credentials and print success message. Replace with actual user name/password  **/        System.out.println ("Successful login"); }    else                             ,e)                            );       }}`;