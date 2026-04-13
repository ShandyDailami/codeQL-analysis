import java.util.HashMap;
import java.util.Map;

public class java_06814_CredentialValidator_A07 {
    private Map<String, String> userDatabase;

    public java_06814_CredentialValidator_A07() {
        userDatabase = new HashMap<>();
        userDatabase.put("admin", "password");
    }

    public boolean validateCredentials(String username, String password) {
        if (userDatabase.containsKey(username) && userDatabase.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Validate credentials
        if (validator.validateCredentials("admin", "password")) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are invalid.");
        }
    }
}