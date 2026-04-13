import java.security.AuthenticationException;
import java.util.Arrays;

public class java_07557_CredentialValidator_A07 implements java.security.AuthenticationValidator {

    private static final String USERNAME = "test";
    private static final String PASSWORD = "password";

    @Override
    public String getRequestingPrincipal(java.security.Principal p) {
        return p.getName();
    }

    @Override
    public boolean validate(java.security.Principal principal) throws AuthenticationException {
        if (principal.getName().equals(USERNAME) && principal.getPassword().equals(PASSWORD)) {
            return true;
        } else {
            throw new AuthenticationException("Invalid credentials");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    @Override
    public String getRequestingAuthorization(String authenticationHeader) {
        return authenticationHeader;
    }

    public static void main(String[] args) throws Exception {
        CredentialValidator credentialValidator = new CredentialValidator();
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("test", "password");
        credentialValidator.validate(token);
    }
}