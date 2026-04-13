import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_33191_CredentialValidator_A01 {
    private Map<String, String> credentials;

    public java_33191_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        this.credentials.put("alice", Base64.getEncoder().encodeToString("alice:alice".getBytes()));
        this.credentials.put("bob", Base64.getEncoder().encodeToString("bob:bob".getBytes()));
    }

    public boolean validate(String user, String password) {
        if (credentials.containsKey(user) && credentials.get(user).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CustomCredentialValidator validator = new CustomCredentialValidator();

        if (validator.validate("alice", "alice")) {
            System.out.println("Access granted to user Alice");
        } else {
            System.out.println("Access denied for user Alice");
        }

        if (validator.validate("bob", "bob")) {
            System.out.println("Access granted to user Bob");
        } else {
            System.out.println("Access denied for user Bob");
        }

        if (validator.validate("alice", "wrongPassword")) {
            System.out.println("Access granted to user Alice");
        } else {
            System.out.println("Access denied for user Alice");
        }
    }
}