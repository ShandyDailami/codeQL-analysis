import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

public class java_13546_CredentialValidator_A03 implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;

    public java_13546_CredentialValidator_A03(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Here we would typically query our database for the user, 
        // but for this example we're just using a hardcoded user
        return new User(username, passwordEncoder.encode("password"), AuthorityUtils.createAuthorityList("ROLE_USER"));
    }
}