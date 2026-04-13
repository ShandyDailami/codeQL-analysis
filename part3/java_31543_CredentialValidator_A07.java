import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_31543_CredentialValidator_A07 {

    private Map<String, String> credentials;

    public java_31543_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
        // add some sample credentials
        this.credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        this.credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validateCredentials(String username, String password) {
        if (credentials.containsKey(username)) {
            String storedPassword = credentials.get(username);
            return storedPassword.equals(Base64.getEncoder().encodeToString(password.getBytes()));
        } else {
            throw new SecurityException("Unknown user.");
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        try {
            validator.validateCredentials("user1", "password1");
            System.out.println("Valid credentials");
        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        }

        try {
            validator.validateCredentials("unknownUser", "password1");
        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        }
    }
}