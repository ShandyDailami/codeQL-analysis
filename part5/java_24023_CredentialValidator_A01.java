import javax.security.auth.CredentialValidationResult;
import javax.security.auth.login.CredentialException;
import javax.security.auth.validation.DefaultValidationResult;
import java.util.HashMap;
import java.util.Map;

public class java_24023_CredentialValidator_A01 {

    private Map<String, String> credentials;

    public java_24023_CredentialValidator_A01() {
        credentials = new HashMap<>();
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    public CredentialValidationResult validate(String username, String password) throws CredentialException {
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            return new DefaultValidationResult("Success", null);
        } else {
            return new DefaultValidationResult("Failure", "Invalid credentials", null);
        }
    }
}