import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;

public class java_30608_CredentialValidator_A03 implements AuthenticationProvider {
    private final PasswordEncoder passwordEncoder;

    public java_30608_CredentialValidator_A03(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        // This is a dummy check. In a real-world application, you'd want to compare the hashed password with the actual password.
        if (name.equals("user") && passwordEncoder.matches(password, "$2a$10$EI.aT9j9G.hB.p4.iD8.KqMz4Z.B.OaI59D6GKO3OG98D2ZvZ")) {
            return new UsernamePasswordAuthenticationToken(name, password);
        } else {
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}