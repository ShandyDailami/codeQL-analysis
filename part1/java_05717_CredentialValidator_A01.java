import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_05717_CredentialValidator_A01 {

    private Map<String, String> credentials;

    public java_05717_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        initCredentials();
    }

    private void initCredentials() {
        credentials.put("admin", Base64.getEncoder().encodeToString("admin:admin".getBytes()));
        credentials.put("user1", Base64.getEncoder().encodeToString("user1:user1".getBytes()));
        credentials.put("user2", Base64.getEncoder().encodeToString("user2:user2".getBytes()));
    }

    public boolean validate(String username, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return credentials.containsKey(username) && credentials.get(username).equals(encodedPassword);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        boolean isValidated = validator.validate("admin", "admin");
        System.out.println("Is validated for admin? " + isValidated);

        isValidated = validator.validate("user1", "user1");
        System.out.println("Is validated for user1? " + isValidated);

        isValidated = validator.validate("user2", "user2");
        System.out.println("Is validated for user2? " + isValidated);
    }
}