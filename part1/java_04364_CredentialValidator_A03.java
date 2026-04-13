import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.List;

public class java_04364_CredentialValidator_A03 extends DaoAuthenticationProvider {

    private List<String> allowedUsernames = new ArrayList<>();

    public java_04364_CredentialValidator_A03() {
        // Initialize the list with some predefined usernames
        this.allowedUsernames.add("user1");
        this.allowedUsernames.add("user2");
        this.allowedUsernames.add("user3");
    }

    @Override
    public Authentication authenticate(Authentication authentication) {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        if (this.allowedUsernames.contains(name)) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            return new UsernamePasswordAuthenticationToken(name, password, authorities);
        } else {
            throw new BadCredentialsException("Invalid username or password");
        }
    }
}