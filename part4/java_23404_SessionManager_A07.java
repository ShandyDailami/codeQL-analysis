import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsService;

public class java_23404_SessionManager_A07 implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // In a real application, you would want to look up the user in your database
        // and return a UserDetails object instead.
        return new User(username, "", true, true, true, true, User.withDefaultPasswordEncoder().roles("USER"));
    }
}