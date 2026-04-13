import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class java_39552_CredentialValidator_A07 implements AuthenticationProvider {

    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "password";

    @Override
    public Authentication authenticate(Authentication authentication) {
        Optional<String> userName = Optional.ofNullable(authentication.getName());
        Optional<String> password = Optional.ofNullable(authentication.getCredentials().toString());

        if (userName.isPresent() && password.isPresent()) {
            if(userName.get().equals(ADMIN_USERNAME) && password.get().equals(ADMIN_PASSWORD)) {
                return new UsernamePasswordAuthenticationToken(userName.get(), password.get(),
                        AuthorityUtils.createAuthorityList("ROLE_ADMIN"));
            }
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}