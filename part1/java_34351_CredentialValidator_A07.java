import org.springframework.security.authentication.CredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;

public class java_34351_CredentialValidator_A07 extends DaoAuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws CredentialsException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        if ("foo".equals(name) && "bar".equals(password)) {
            return new UsernamePasswordAuthenticationToken(name, password, AuthorityUtils.createAuthorityList("ROLE_USER"));
        } else {
            throw new CredentialsException("Invalid username or password");
        }
    }
}