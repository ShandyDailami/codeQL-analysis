import java.util.Base64;
import java.util.Map;

public class java_01705_CredentialValidator_A03 implements CredentialValidator {

    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String BASE64_CREDENTIALS = "dGVzdCBib2R5"; // Base64 of "username:password"

    @Override
    public boolean validate(Map<String, String> credentials) {
        if (!credentials.containsKey(USERNAME) || !credentials.containsKey(PASSWORD)) {
            throw new CredentialValidationException("Missing username or password in credentials");
        }

        String providedUsernamePassword = credentials.get(USERNAME) + ":" + credentials.get(PASSWORD);
        String expectedUsernamePassword = new String(Base64.getDecoder().decode(BASE64_CREDENTIALS));

        if (!providedUsernamePassword.equals(expectedUsernamePassword)) {
            throw new CredentialValidationException("Invalid credentials");
        }

        return true;
    }
}