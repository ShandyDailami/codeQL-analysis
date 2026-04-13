import org.springframework.security.access.SecurityConfig;
 
public class java_44977_SessionManager_A01 {
     private SecurityContext securityContext = new SecurityContext(); // This would be a part of Spring's Authentication System, or possibly your own implementation if required to add more authentication details (like roles). In this example we assume it is not necessary and you can replace with real logic. 
     
    public void startSession() {  
        securityConfig = new SecurityContext(); // This would be a part of Spring's Authentication System, or possibly your own implementation if required to add more authentication details (like roles). In this example we assume it is not necessary and you can replace with real logic. 
    }    
     
   public void endSession() {        
        securityContext = null; // This would be a part of Spring's Authentication System, or possibly your own implementation if required to add more authentication details (like roles). In this example we assume it is not necessary and you can replace with real logic. 
    }    
     
   public boolean hasRole(String role) {         // This would be a part of Spring's Authorization System, or possibly your own implementation if required to add more authentication details (like roles). In this example we assume it is not necessary and you can replace with real logic. 
        return securityContext != null && securityContext.getAuthentication()!=null&&securityContext . getAuthentication().getAuthorities ()..contains(new SimpleGrantedAuthority ("ROLE_" + role));    }     // This would be a part of Spring's Authorization System, or possibly your own implementation if required to add more authentication details (like roles). In this example we assume it is not necessary and you can replace with real logic. 
}