import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
  
@RequestMapping("/secure") // define your secured endpoints here   
public class java_48138_SessionManager_A07 { 
    
	@GetMapping("adminAccessOnly")// only admin can access this endpoint, other users will be redirected to login page by security config     
	public String secureAdminArea(Authentication auth)   throws Exception{      
		if (auth == null || !auth.isAuthenticated()) {  // if not authenticate then throw unauthorized error       		        	 	     	   			    				    } else          System.out.println("Welcome admin!");      return "adminDashboard";   }            @GetMapping("/userAccess")
	public String secureUserArea(Authentication auth) throws Exception {       if (auth == null || !auth.isAuthenticated())       			{throw new Exception ("Unauthorized access : Requesting user data"); 				} else          System.out.println("Welcome User!");      return "userDashboard";   }
}