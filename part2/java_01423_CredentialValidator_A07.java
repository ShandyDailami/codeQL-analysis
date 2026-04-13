import java.util.Base64;
import java.util.HashMap;

public class java_01423_CredentialValidator_A07 {

    private HashMap<String, String> users = new HashMap<>();

    public java_01423_CredentialValidator_A07() {
        users.put("alice", Base64.getEncoder().encodeToString("alice:alice".getBytes()));
        users.put("bob", Base64.getEncoder().encodeToString("bob:bob".getBytes()));
    }

    public boolean validate(String user, String password) {
        String encodedUserPassword = Base64.getEncoder().encodeToString(user.concat(":").concat(password).getBytes());
        return users.get(user).equals(encodedUserPassword);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        if (validator.validate("alice", "alice")) {
            System.out.println("Alice is authenticated successfully!");
        } else {
            System.out.println("Authentication failed for Alice!");
        }

        if (validator.validate("bob", "bob")) {
            System.out.println("Bob is authenticated successfully!");
        } else {
            System.out.println("Authentication failed for Bob!");
        }
    }
}