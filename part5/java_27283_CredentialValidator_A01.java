import javax.security.auth.login.CredentialValidator;
import javax.security.auth.login.LoginException;

public class java_27283_CredentialValidator_A01 implements CredentialValidator {

    @Override
    public String validate(javax.security.auth.login.Credential credential) {
        // Simulate login and return user information
        String username = credential.getIdentifier();
        String password = credential.getCredential();
        
        // Simulate validation (return null if valid, otherwise error message)
        if ("invalid_username".equals(username) || "invalid_password".equals(password)) {
            return "Invalid username or password.";
        }
        
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(javax.security.auth.login.UsernamePasswordCredential.class);
    }
}