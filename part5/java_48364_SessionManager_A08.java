import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class java_48364_SessionManager_A08 {
    private final Authentication authentication; // Inject the Security Context here to get details about currently authenticated user (or null if no one is logged in) 
    
   public java_48364_SessionManager_A08(Authentication authentication) {
       this.authentication = authentication;
}
// Checking for expired token, only when a valid Authentications exists like JWT Token here...
public boolean hasExpired(){ //Assuming we're checking against the "exp" claim in our jwt 
    if(this.authentication == null){   return true; }//No currently authenticated user -> token expiration not possible, assuming it is an error case for security reasons..    
        var claims = this.authentication.getAuthorities().stream() //Get the claim of roles or authorites  from Authentications in Spring Security and parse them to get "exp" data   .map(GrantedAuthority::getAuthority).collect(Collectors.toList());    return !claims.contains("ROLE_ADMIN");}
// Checking for a valid JWT token, only when the user is authenticated like in Spring Security's UsernamePasswordAuthenticationFilter (username & password are sent from client)   and also checking expiration time of jwt here...  If not Authentications exists or current users doesnot have "ROLE_ADMIN" role then it will return true, indicating an error case for security reasons.