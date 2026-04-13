import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController // This means it's a controller for REST API endpoints 
public class java_47473_CredentialValidator_A03 {  
    @RequestMapping(value = "/validate", method= RequestMethod.POST)// Endpoint to validate user credentials (assuming we are using Spring Security here).
     public String login(@RequestParam("username")String username,@RequestParam("password")String password){  // Get the submitted data from request parameters  
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();    /* Define a Bcrypt Password Encoding */     
         if(encoder.matches(password , "$2a$10$s/M3Yvw4xZRqhPmTd9EeFzKJVgCcQy7lI6Nu")){ /* Compare the submitted password with hashed one stored in database (Assume it's a Bcrypt hash) */
             return "Valid User";   // Return Success if user credentials are valid.  Otherwise, Invalid Credentials can be returned here as well!    } else {return"Invalid Password"} ;    
      }} )}`;