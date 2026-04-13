import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class java_30618_CredentialValidator_A01 {
    public static void main(String[] args) {
        // Create a password encoder
        PasswordEncoder passwordEncoder = NoOpPasswordEncoder.getInstance();

        // Create a dao authentication provider
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);

        // Create a user details
        UserDetails user = User.withUsername("user")
                .password(passwordEncoder.encode("password"))
                .authorities("ROLE_USER")
                .build();

        // Set user details to authentication provider
        provider.setUserDetailsService(userDetails -> user);

        // Validate the credentials
        provider.authenticate(userDetails -> {
            // This should not be called in real world
            return null;
        });
    }
}