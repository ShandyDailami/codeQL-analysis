import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.password.PasswordEncoder;

public class java_16230_CredentialValidator_A07 implements AuthenticationProvider {

    private final PasswordEncoder passwordEncoder;

    public java_16230_CredentialValidator_A07(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        if (name.equals("user") && passwordEncoder.matches(password, "$2a$10$eIKFv.IoY/3Xr.YcXK8u5.DfYX3Ea.6H.WpH/Kj3b.LdZQfu")) { // This is a mock password
            return new UsernamePasswordAuthenticationToken(name, password, AuthorityUtils.createAuthorityList("ROLE_USER"));
        } else {
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}