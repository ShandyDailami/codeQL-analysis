import org.springframework.beans.*;
  import static spark.Spark.*;
  
public class java_51876_CredentialValidator_A07 {     // Main Class for our program      
    public String validate(String userName, String password) throws Exception{          
        if (userNames.contains(userName))            
            return "InvalidPassword";         
         else                
                throw new AuthenticationFailedException("Authentication failed");  }     
   static List<Object> userNames = new ArrayList<>();    // list of valid users      
}     /* End Main class */