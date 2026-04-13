import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public class java_35259_CredentialValidator_A07 extends DaoAuthenticationProvider {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public java_35259_CredentialValidator_A07(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected Authentication attemptAuthentication(Authentication authentication) {
        Optional<String> username = Optional.ofNullable(authentication.getPrincipal() + "");
        Optional<String> password = Optional.ofNullable(authentication.getCredentials() + "");

        if (username.isPresent() && password.isPresent()) {
            String presentedPassword = passwordEncoder.encode(password.get());
            UserDetails user = userDetailsService.loadUserByUsername(username.get());

            if (!passwordEncoder.matches(password.get(), user.getPassword())) {
                throw new BadCredentialsException("Authentication failed: bad credentials");
            } else {
                return new UsernamePasswordAuthenticationToken(user, presentedPassword, user.getAuthorities());
            }
        } else {
            throw new BadCredentialsException("Authentication failed: no credentials provided");
        }
    }
}