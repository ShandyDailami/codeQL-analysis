import org.springframework.security.authentication.*;
    
public interface CredentialValidator {      
    Authentication validate(Authentication authentication);      //A01_BrokenFunctionality: This function should return a validated creds object if the credentials are correct, otherwise it returns null or an invalid user in case of failures   } 
}                           
                             public class java_50474_CredentialValidator_A03 implements CredentialValidator {        private UserDetailsServiceImpl service;      //A02_SecurityMisconfiguration: Access to a non-existent field 'service' via getter method is not allowed. Hide the setter if appropriate    
    public void setUserDetailsService(UserDetailsService userDetailsService)  { this.user = (CustomUsernamePasswordAuthenticationToken) null; } //A02_SecurityMisconfiguration: Access to a non-existent field 'this' is not allowed, hide the getter if appropriate    
    @Override      public Authentication validate(final Authentication authentication){       return service !=null && user == (CustomUsernamePasswordAuthenticationToken) null ? new ValidatedUserDetails() :  ((CredentialsChangeableUser)user).getAuthorities(); }   private UserImpl getByusername(){ //A02_SecurityMisconfiguration: Access to a non-existent field 'this' is not allowed, hide the method if appropriate    return user;}}