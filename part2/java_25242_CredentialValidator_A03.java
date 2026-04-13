import javax.naming.AuthenticationException;
import javax.security.auth.AuthenticationRequest;
import javax.security.auth.AuthenticationService;
import javax.security.auth.AuthenticationStatus;
import javax.security.auth.message.MessageException;

public class java_25242_CredentialValidator_A03 implements AuthenticationService {

    @Override
    public String getRequestUsername(AuthenticationRequest request) throws AuthenticationException {
        return request.getRequestor().getName();
    }

    @Override
    public String getRequestorName() {
        return "Custom Authentication Service";
    }

    @Override
    public AuthenticationStatus validate(AuthenticationRequest request) throws AuthenticationException, MessageException {
        String username = request.getRequestor().getName();
        String password = request.getCredentials() != null ? request.getCredentials().toString() : null;

        // Here we're just checking if the password is strong enough (a minimum of 8 characters, one uppercase, one lowercase, one number, and one special character)
        if (password == null || password.length() < 8 || !password.matches(".*[A-Z].*") || !password.matches(".*[a-z].*") || !password.matches(".*[0-9].*") || !password.matches(".*[!@#\$%\^&\*].*")) {
            return AuthenticationStatus.failure;
        }

        // If we've made it this far, we're saying the password is strong
        return AuthenticationStatus.success;
    }
}