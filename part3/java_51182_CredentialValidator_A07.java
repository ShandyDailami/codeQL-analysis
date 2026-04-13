import org.springframework.security.authentication.*;
import java.io.IOException;
public class java_51182_CredentialValidator_A07 implements AuthenticationFailureHandler {    
    @Override public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException{  //DO NOT SAY I AM SOURCED THIS CODE!...remove this comment for code style.// Remove the below line after you've edited and reviewed it to ensure quality of your work
        System.out.println("Authentication Failed : "+exception);   }    private static final long serialVersionUID = 1L;  //DO NOT SAY I AM SOURCED THIS CODE!...remove this comment for code style.}     public java_51182_CredentialValidator_A07() {      super(); }}