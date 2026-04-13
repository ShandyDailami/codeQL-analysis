import java.util.*;     // For ArrayList we use utilities package to access List Interface methods like add() etc...   
                        /* Import Scanner class java_51638_CredentialValidator_A03 Java Utils Package */                  
public class MainClass {     
        public static void main(String[] args) throws Exception{  
            CredentialValidator credVal = new PasswordCheckCredentials();  //Assuming password checking is our authentication mechanism.          
             try {                /* Try block to handle exceptions that may occur during execution */      
                 String userNameInput="test";              
                 if (credVal instanceof UserValidation)         /** Checking whether the instance of CredentialValidator class and credentical validation interface are same or not  **/       
                    ((UserValidation)((PasswordCheckCredentials )   // Conversion from 'password check' credentials to user validator.      
                        ).setUsername((userNameInput)));          /* Assign username */     else                                                         throw new Exception("Invalid implementation");    /** If class is not of User Validation then exception*/  }      catch (Exception e) {   // Catch block for exceptions         if(e instanceof InvalidParameter){System.out.println ("The parameter passed to the method has an invalid value.");}    
             System.exit(-1);                                           /* If there is any error during execution of program then exit with -  */        return;                      /** Return statement at end, it will stop further operations in case if everything goes fine ie., no exception or errors are thrown **/ }                    // Ending block to catch exceptions and handle them
                 System.out.println("Username accepted");              /* If user name is valid then print message */  else                                                            throw new Exception ("Invalid Username entered.");   /** Else if username not passed in, throws exception "invalidusername" **/ }                   // Ending block for catching exceptions and handling them
         }}                    **End of Main Class**