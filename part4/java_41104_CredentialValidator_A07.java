import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_41104_CredentialValidator_A07 {

    private Map<String, String> users = new HashMap<>();

    public java_41104_CredentialValidator_A07() {
        users.put("user1", "password1");
        users.put("user2", "password2");
        users.put("user3", "password3");
    }

    public boolean validate(String user, String password) {
        String expectedPassword = users.get(user);
        if (expectedPassword == null) {
            return false;
        }

        String encryptedExpectedPassword = Base64.getEncoder().encodeToString(expectedPassword.getBytes());
        String encryptedProvidedPassword = Base64.getEncoder().encodeToString(password.getBytes());

        return encryptedExpectedPassword.equals(encryptedProvidedPassword);
    }
}