import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import org.springframework.security.web.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class java_45826_CredentialValidator_A01 implements AuthenticationFilter {   // A custom filter for authentication purposes in Spring Security 5+ with the @EnableWebSecurity annotation or programmatically via setAuthenticationManager() and addFilterBefore(). Here, I've used a functional interface as an argument to replace `Credentials`
{
    private static final String REFERER = "referer";   // If user is being redirected back due to access rights (A01_BrokenAccessControl), store the referer in this variable 
    
        @Override
       public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws ServletException {    return null; }   // Returning NULL as we don't use forms or database here. Spring Security uses a filter chain to handle form authentication (with username and password). If you do not need this functionality then it is good enough
       public void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, ServletResponse response1) throws IOException { }    // On success we don't have any servlets or responses here. We just return nothing because in A02_ElevatedAccessControl scenario you would typically redirect back to the referer if access rights were not granted (AFAIK Spring Security does this automatically for role based authentication)
     public void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) {    // If there was an exception in our attempt then we can handle it here. In A01_BrokenAccessControl scenario you would typically redirect back to the referer if access rights were not granted
          String message = "You do not have permission for this operation.";   // Message sent when user doesnt't possess necessary role(s) and is trying action which requires it. This could be customised based on context (e.g., in terms of what kind the error means, why they tried to access a resource etc.)
          throw new InsufficientAuthenticationException("Insufficient Authentication: " + message);   // Throw an exception with our own status that spring security can catch and handle accordingly – ehrm... you'll have no referer when redirecting back here for A01_BrokenAccessControl. You could also implement redirection to the referrer instead of throwing this in a real world scenario
     }   // The unsuccessfulAuthentication method is called by Spring Security if authentication fails, and we can provide some useful information about why it failed (e.g., username or password was incorrect) – ehrm... for A01_BrokenAccessControl you'll have no referrer to redirect back here
}    // It’s important that this class is the same name as in your security configuration and methods are public so they can be called from outside. Spring Security will call these when it needs information about a failed authentication attempt (A01_BrokenAccessControl scenario). In AFAIK, Redirecting to referrer should work fine here for Role-Based Access Control as well but that is due the implementation of how access rights are handled in your application.