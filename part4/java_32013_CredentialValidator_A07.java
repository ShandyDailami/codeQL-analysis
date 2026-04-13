import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_32013_CredentialValidator_A07 {
    private Map<String, String> credentials;

    public java_32013_CredentialValidator_A07() {
        credentials = new HashMap<>();
        credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validate(String username, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return credentials.get(username).equals(encodedPassword);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        boolean isValid = validator.validate("user1", "password1");
        System.out.println("Is user1 valid? " + isValid);

        isValid = validator.validate("user2", "password2");
        System.out.println("Is user2 valid? " + isValid);
    }
}