import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.providers.dao.UsernamePasswordAuthenticationProvider;

public class java_00893_CredentialValidator_A03 {

    // This is a placeholder password, replace with actual password
    private static final String ACTUAL_PASSWORD = "password";

    public static void main(String[] args) {
        try {
            validateCredentials("username", "wrong_password");
        } catch (BadCredentialsException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void validateCredentials(String username, String password) throws BadCredentialsException {
        // Create a provider instance
        UsernamePasswordAuthenticationProvider provider = new UsernamePasswordAuthenticationProvider();

        // Authenticate the user
        Authentication authentication = provider.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        // If the user is not authenticated, throw a BadCredentialsException
        if (authentication == null) {
            throw new BadCredentialsException("Invalid username or password");
        }

        // Update the security context
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}