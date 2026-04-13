import org.springframework.security.authentication.CredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public class java_30099_CredentialValidator_A01 {

    private DaoAuthenticationProvider daoAuthenticationProvider;

    public java_30099_CredentialValidator_A01(DaoAuthenticationProvider daoAuthenticationProvider) {
        this.daoAuthenticationProvider = daoAuthenticationProvider;
    }

    public void validateCredentials(String username, String password) throws AuthenticationException {
        Authentication authentication = daoAuthenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        if (authentication.isAuthenticated()) {
            System.out.println("User authenticated successfully");
        } else {
            throw new CredentialsException("Invalid username or password");
        }
    }

    public static void main(String[] args) {
        // You can add your own user details here
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();

        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return user;
            }
        });

        CredentialValidator validator = new CredentialValidator(daoAuthenticationProvider);
        validator.validateCredentials("user", "password");
    }
}