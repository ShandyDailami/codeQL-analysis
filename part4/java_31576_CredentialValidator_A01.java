import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class java_31576_CredentialValidator_A01 implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // For simplicity, we are using a in-memory user store.
        // In a real-world application, user details should be fetched from a database.
        if ("admin".equals(username)) {
            return new User("admin", new BCryptPasswordEncoder().encode("password"), AuthorityUtils.createAuthorityList("ROLE_ADMIN"));
        } else if ("user".equals(username)) {
            return new User("user", new BCryptPasswordEncoder().encode("password"), AuthorityUtils.createAuthorityList("ROLE_USER"));
        } else {
            throw new UsernameNotFoundException("No user found with username: " + username);
        }
    }

    public Authentication validate(String username, String password) {
        try {
            // Using the loadUserByUsername method to load the user's details.
            UserDetails user = loadUserByUsername(username);
            // Using the BCryptPasswordEncoder to check the password.
            if (new BCryptPasswordEncoder().matches(password, user.getPassword())) {
                return new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
            }
        } catch (BadCredentialsException badCredentialsException) {
            // If the credentials are invalid, throw an exception.
            throw badCredentialsException;
        }
        // If no exception was thrown, return null.
        return null;
    }
}