import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_22773_CredentialValidator_A01 {

    private Map<String, String> credentialMap;

    public java_22773_CredentialValidator_A01() {
        credentialMap = new HashMap<>();
        credentialMap.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        credentialMap.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
        // Add more users as needed
    }

    public boolean validateCredentials(String user, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return credentialMap.get(user) != null && credentialMap.get(user).equals(encodedPassword);
    }

    public static void main(String[] args) {
        SecureCredentialValidator validator = new SecureCredentialValidator();
        System.out.println(validator.validateCredentials("user1", "password1")); // true
        System.out.println(validator.validateCredentials("user1", "wrongpassword")); // false
        System.out.println(validator.validateCredentials("user3", "password3")); // false
    }
}