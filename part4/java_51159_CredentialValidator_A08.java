public class java_51159_CredentialValidator_A08 {   // Class name should be descriptive of the credential entity's purpose in context and functionality ie., Username, Password etc.. Also it is a bad practice naming convention to use words like 'Simple', this example follows your requirements more directly. 
    private String username;        // This can also include sensitive data that you do not want exposed such as password or credit card information in real applications but for the sake of simplicity, keeping things simple here..  
    
    public java_51159_CredentialValidator_A08(String name) {         // Constructor to initialize credentials object. 
      this.username =name;         
       }                                                         
                                 
public boolean validate(){                    /*Method that you can use in your code as a way of validating the Credential */  
     if (this.isValid() ){            
         return true;}                  //This could be used to check password strength, expiry date etc.. and is not real security sensitive operation but for demo purposes it's fine here  .    else {              System.out.println("Invalid Credentials");           }   /* end if */                            
     return false;                    //if credentials are invalid then the function returns true otherwise as mentioned in above line, prints an error message to console and hence security sensitive operation is not done but it's just for demonstration purpose .  So please replace this with real business logic.    }); }   /* end method */