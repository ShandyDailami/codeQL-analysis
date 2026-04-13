import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_14563_CredentialValidator_A03 {

    private Map<String, String> credentialMap;

    public java_14563_CredentialValidator_A03() {
        credentialMap = new HashMap<>();
        credentialMap.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        credentialMap.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validateCredentials(String username, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return credentialMap.get(username) != null && credentialMap.get(username).equals(encodedPassword);
    }

    public static void main(String[] args) {
        LegacyCredentialValidator validator = new LegacyCredentialValidator();

        if (validator.validateCredentials("user1", "password1")) {
            System.out.println("User 1 logged in successfully");
        } else {
            System.out.println("Failed to log in as user 1");
        }

        if (validator.validateCredentials("user2", "password2")) {
            System.out.println("User 2 logged in successfully");
        } else {
            System.out.println("Failed to log in as user 2");
        }
    }
}