import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_31342_CredentialValidator_A03 {

    private Map<String, String> users;

    public java_31342_CredentialValidator_A03() {
        this.users = new HashMap<>();
        users.put("alice", Base64.getEncoder().encodeToString("password1".getBytes())); // Alice is an admin.
        users.put("bob", Base64.getEncoder().encodeToString("password2".getBytes())); // Bob is not an admin.
    }

    public boolean validateCredentials(String username, String password) {
        if (users.containsKey(username)) {
            String encodedPassword = users.get(username);
            byte[] decodedBytes = Base64.getDecoder().decode(encodedPassword);
            String decodedPassword = new String(decodedBytes);

            return decodedPassword.equals(password);
        } else {
            System.out.println("Invalid username");
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        boolean isValid = validator.validateCredentials("alice", "password1"); // Returns true
        System.out.println("Is Alice valid? " + isValid);

        isValid = validator.validateCredentials("bob", "password2"); // Returns false
        System.out.println("Is Bob valid? " + isValid);

        isValid = validator.validateCredentials("alice", "wrongpassword"); // Returns false
        System.out.println("Is Alice valid? " + isValid);
    }
}