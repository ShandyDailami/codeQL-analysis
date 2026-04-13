import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_41989_CredentialValidator_A03 implements CredentialValidator {

    private Map<String, String> userCredentials;

    public java_41989_CredentialValidator_A03() {
        userCredentials = new HashMap<>();
        userCredentials.put("user1", "password1");
        userCredentials.put("user2", "password2");
        userCredentials.put("user3", "password3");
    }

    @Override
    public boolean validate(String userName, String password) {
        String expectedPassword = userCredentials.get(userName);
        if (expectedPassword == null) {
            return false;
        }

        String expectedPasswordBase64 = Base64.getEncoder().encodeToString(expectedPassword.getBytes());
        String providedPasswordBase64 = Base64.getEncoder().encodeToString(password.getBytes());

        return expectedPasswordBase64.equals(providedPasswordBase64);
    }
}