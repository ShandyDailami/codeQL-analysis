import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_36075_CredentialValidator_A07 {
    private Map<String, String> users;

    public java_36075_CredentialValidator_A07() {
        users = new HashMap<>();
        users.put("alice", Base64.getEncoder().encodeToString("alice:alice".getBytes())); // Alice password is "alice:alice"
        users.put("bob", Base64.getEncoder().encodeToString("bob:bob".getBytes())); // Bob password is "bob:bob"
    }

    public boolean validate(String user, String password) {
        String expectedPassword = users.get(user);
        if (expectedPassword == null) {
            return false;
        }

        String providedPassword = new String(Base64.getEncoder().encode(password.getBytes())); // Provided password is the password in plain text

        return expectedPassword.equals(providedPassword);
    }
}

public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Alice attempts to log in
        boolean isLoggedInAlice = validator.validate("alice", "alice");
        System.out.println("Is Alice logged in? " + isLoggedInAlice);

        // Bob attempts to log in
        boolean isLoggedInBob = validator.validate("bob", "bob");
        System.out.println("Is Bob logged in? " + isLoggedInBob);
    }
}