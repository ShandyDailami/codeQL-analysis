import java.util.*;

public class java_42589_CredentialValidator_A07 {
    public static void main(String[] args) throws Exception{    
        CredentialValidator validator = new MyCredentials();        
       try {            
           String userName="test";          //hardcoded username  for this example           
           char [] password=  {'a','b', '3'};   // hard coded Password (password is not recommended in real world)       
                                                     
                   validator.validate(userName, Arrays.toString(password));        
       }catch (Exception e){               
               System.out.println("Credentials validation failed: " +e);           
           };            
    }    
}  // end of main method