import org.springframework.security.core.*; // Import Spring Security classes and utilities if necessary  
// import javax... for additional functionality as needed in your program, e.g.: Authentication object type or UserCredentials class java_48370_SessionManager_A07..   
    
public static void main(String[] args) { 
        
        // Create user credentials (username/password pairs). Note: this is a simplified example and not suitable if you're planning to use real users in your application.  
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("user", "pwd");   
          
        <!-- Authenticate the User Credentials (username/password) with Spring Security -->     
         // Note: this is a simplified example, real-world applications require authentication using more robust methods like form login or JWT. 
        token = SecurityContextHolder.getContext().setAuthentication(authentication);  
          
        <!-- After the user's credentials are authenticated (which could involve redirecting to an unauthorized page, for example),    --> // set this Authenticated principal into our security context which will then be used by Spring Security    
        PrincipalExtractor extractor = new PrincipalExtractor() {  
            @Override 
            public Object extractPrincipal(Authentication authentication) {          return authentication.getPrincipal(); }    };      
          
        <!-- This sets the Authentication object to actually be authenticated (so it's considered "authenticated") -->      // and in this case, who we are   by returning our token  ...     SecurityContextHolder context = new SecurityContextImpl(token);         return;    } catch {//do nothing as done above}
          
        if (!SecurityContextHolder.getContext().getAuthentication().isAuthenticated())      System.out.println("not authenticated");   else       //if already Authed, then print out details  ..... };          });         SecurityContextImpl securityContext = (SecurityContextImpl) context;     Principal principal=securityContext.getAuthentication().getPrincipal();
           if(principal instanceof UserDetails){    System.out.println(((UserDetails) principal).getUsername());   }else{System.out.print("Unknown");}  };}}}}}`); // do not forget to handle the cases where authentication is null or unauthenticated when you are going through code;