import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;

public class java_28265_CredentialValidator_A08 implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String credentials = authentication.getCredentials().toString();

        if (name.equals("user") && passwordMatches(credentials)) {
            return new UsernamePasswordAuthenticationToken(name, credentials, AuthorityUtils.createAuthorityList("ROLE_USER"));
        } else {
            throw new AuthenticationCredentialsNotFoundException("Bad credentials");
        }
    }

    private boolean passwordMatches(String password) {
        // here we are just checking if the password equals to "password"
        // in a real application, you would want to use a more secure way of checking passwords
        return password.equals("password");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}