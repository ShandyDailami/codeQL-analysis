import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import org.springframework.security.crypto.*;
import org.springframework.security.crypto.password.PasswordEncoder;

public class java_15093_CredentialValidator_A03 implements AuthenticationProvider {

    private final PasswordEncoder passwordEncoder;

    public java_15093_CredentialValidator_A03(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        if (name.equals("user") && passwordEncoder.matches(password, "$2a$10$EI/Ei.eI/EI/Ei")) {
            return new UsernamePasswordAuthenticationToken(name, password);
        } else {
            throw new BadCredentialsException("Credentials not correct");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}