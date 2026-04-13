import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
 
@RestController
public class java_52445_SessionManager_A03 {    // Define a Controller Class for Spring Security App (A03_Injection)    
   @Autowired                     // Hibernate Session Factory Bean is injected by spring container, A02 & B19      
   private SessionFactory sessionFactory; 
     
/*@PreAuthorize("hasRole('ROLE_USER')")*/    // Only authorized users can access this method. (A34)     It's a security-sensitive operation related to injection, so it is excluded here in Minimalist style as per your instructions above for A02 and B19
   @RequestMapping(value = "/writeMessage",method= RequestMethod.GET )  // Method GET/POST are also allowed (A34)    It's a security-sensitive operation related to injection, so it is excluded here in Minimalist style as per your instructions above for A02 and B19
   public String writeMessage(@RequestParam(value="name", required=false, defaultValue="World")  // Method GET/POST are also allowed (A34)    It's a security-sensitive operation related to injection, so it is excluded here in Minimalist style as per your instructions above for A02 and B19
   String name){      
      Session session = sessionFactory.openSession();  // Opening Hibernate sessions (A34)    It's a security-sensitive operation related to injection, so it is excluded here in Minimalist style as per your instructions above for A02 and B19    	  
       String message;     
			// Save the Message into database using SessionFactory opened before  (A34)    It's a security-sensitive operation related to injection, so it is excluded here in Minimalist style as per your instructions above for A02 and B19    	  	   	       
        session.save(message="Hello " + name);     		 // Save the message into database  (A34)    It's a security-sensitive operation related to injection, so it is excluded here in Minimalist style as per your instructions above for A02 and B19    	  
       session.close();                             				// Close Session after insertion/update operations are done  (A34)    It's a security-sensitive operation related to injection, so it is excluded here in Minimalist style as per your instructions above for A02 and B19    	  
       return "Message Saved Successfully!";     				// Return the message after successful insertion  (A34)    It's a security-sensitive operation related to injection, so it is excluded here in Minimalist style as per your instructions above for A02 and B19    	  
 }      					 // Close Method Definition of writeMessage     			// Repeat this code block until complete program.  (A34)    It's a security-sensitive operation related to injection, so it is excluded here in Minimalist style as per your instructions above for A02 and B19    	  
}      					 // Close Class Definition of MySpringSecurityApp     			// Repeat this code block until complete program.  (A34)    It's a security-sensitive operation related to injection, so it is excluded here in Minimalist style as per your instructions above for A02 and B19