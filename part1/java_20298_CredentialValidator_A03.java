import java.util.HashMap;
import java.util.Map;
import java.util.Base64;

public class java_20298_CredentialValidator_A03 {
    private Map<String, String> users;

    public java_20298_CredentialValidator_A03() {
        users = new HashMap<>();
        users.put("alice", hashPassword("password"));
        users.put("bob", hashPassword("bobby"));
    }

    public boolean validate(String username, String password) {
        String hashedPassword = users.get(username);
        if (hashedPassword == null) {
            return false;
        }

        return hashedPassword.equals(hashPassword(password));
    }

    private String hashPassword(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes());
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        boolean valid = validator.validate("alice", "password");
        System.out.println("Alice is " + (valid ? "valid" : "not valid"));

        valid = validator.validate("bob", "bobby");
        System.out.println("Bob is " + (valid ? "valid" : "not valid"));
    }
}