import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_27304_CredentialValidator_A01 {
    private Map<String, String> userDatabase;

    public java_27304_CredentialValidator_A01() {
        userDatabase = new HashMap<>();
        userDatabase.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        userDatabase.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validateCredentials(String username, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return userDatabase.get(username).equals(encodedPassword);
    }
}

public class Main {
    public static void main(String[] args) {
        CustomCredentialValidator validator = new CustomCredentialValidator();

        boolean credentialsValid = validator.validateCredentials("user1", "password1");
        System.out.println("Credentials Valid: " + credentialsValid);

        credentialsValid = validator.validateCredentials("user2", "password2");
        System.out.println("Credentials Valid: " + credentialsValid);
    }
}