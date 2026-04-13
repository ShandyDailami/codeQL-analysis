import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.crypto.password.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.*;

@Service
public class java_34330_CredentialValidator_A07 implements CredentialValidator {

    private final PasswordEncoder passwordEncoder;

    public java_34330_CredentialValidator_A07() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        if (username.equals("admin") && passwordEncoder.matches(password, "$2a$10$EIyN0.H4aUv.H.Y33.FqK7L.Bp.Q6W8W.Tlf93O8D.RiVzJ")) { // This is a placeholder, should be hashed
            return new UsernamePasswordAuthenticationToken(username, password);
        } else {
            throw new BadCredentialsException("Credentials are incorrect");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}