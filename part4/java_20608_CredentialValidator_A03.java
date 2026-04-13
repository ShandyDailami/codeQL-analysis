import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class java_20608_CredentialValidator_A03 implements AuthenticationValidator<AuthnRequest> {

    private static final List<String> COMMON_PASSWORDS = Arrays.asList("password", "admin", "qwerty", "123456", "admin123", "password123", "admin123456");

    @Override
    public AuthenticationValidatorResult validate(AuthnRequest authnRequest) throws AuthenticationException {
        String password = authnRequest.getCredentials();

        if (COMMON_PASSWORDS.contains(password)) {
            throw new BadCredentialsException("Common password found!");
        }

        return AuthenticationValidatorResult.success();
    }
}