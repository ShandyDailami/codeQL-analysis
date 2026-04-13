import org.springframework.security.authentication.CredentialsNotFoundException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.dao.ReflectionUserDetailsService;
import org.springframework.security.authentication.dao.UsernamePasswordAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class java_42165_CredentialValidator_A01 {

    public static void main(String[] args) {
        // Step 1: Define user details service
        UserDetailsService userDetailsService = new ReflectionUserDetailsService();

        // Step 2: Set up authentication provider
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());

        // Step 3: Set up username and password authentication provider
        UsernamePasswordAuthenticationProvider usernamePasswordAuthenticationProvider = new UsernamePasswordAuthenticationProvider();
        usernamePasswordAuthenticationProvider.setUserDetailsService(userDetailsService);
        usernamePasswordAuthenticationProvider.setPasswordEncoder(passwordEncoder());

        // Use the authentication providers
        authenticationProvider.setAuthenticationProvider(usernamePasswordAuthenticationProvider);

        // Use the authentication provider
        authenticationProvider.setAuthenticationProvider(usernamePasswordAuthenticationProvider);

        // Step 4: Validate credentials
        try {
            authenticationProvider.authenticate(null);
            System.out.println("Authentication Successful");
        } catch (CredentialsNotFoundException ex) {
            System.out.println("Authentication Failed: " + ex.getMessage());
        }
    }

    private static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}