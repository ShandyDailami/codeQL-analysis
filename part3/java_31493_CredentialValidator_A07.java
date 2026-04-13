import java.security.GeneralSecurityException;
import java.security.Principal;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_31493_CredentialValidator_A07 implements CredentialValidator {

    private Map<String, String> credentials;

    public java_31493_CredentialValidator_A07() {
        credentials = new HashMap<>();
        credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    @Override
    public Principal validate(String user, String password) throws GeneralSecurityException {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        String expectedPassword = credentials.get(user);

        if (expectedPassword == null || !expectedPassword.equals(encodedPassword)) {
            throw new GeneralSecurityException("Invalid credentials");
        }

        return new Principal() {
            @Override
            public String getName() {
                return user;
            }
        };
    }
}