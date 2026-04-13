import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_13972_CredentialValidator_A03 {
    private Map<String, String> users;

    public java_13972_CredentialValidator_A03() {
        users = new HashMap<>();
        users.put("alice", Base64.getEncoder().encodeToString("password1".getBytes()));
        users.put("bob", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public String validateCredentials(String username, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        String storedPassword = users.get(username);

        if (storedPassword == null) {
            return "Invalid username";
        } else if (!storedPassword.equals(encodedPassword)) {
            return "Invalid password";
        }

        return "Success";
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        System.out.println(validator.validateCredentials("alice", "password1"));
        System.out.println(validator.validateCredentials("bob", "password2"));
        System.out.println(validator.validateCredentials("alice", "wrongpassword"));
    }
}