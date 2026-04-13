import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_11369_CredentialValidator_A01 {

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.validate("user1", "password1");
        validator.validate("user2", "password2");
    }

}

class CredentialValidator {

    private Map<String, String> credentials;

    public java_11369_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public void validate(String username, String password) {
        if (!credentials.containsKey(username)) {
            System.out.println("Access Denied: Invalid username.");
        } else if (!isPasswordValid(username, password)) {
            System.out.println("Access Denied: Invalid password.");
        } else {
            System.out.println("Access Granted: Welcome, " + username);
        }
    }

    private boolean isPasswordValid(String username, String password) {
        String encodedPassword = credentials.get(username);
        byte[] decodedBytes = Base64.getDecoder().decode(encodedPassword);
        String decodedPassword = new String(decodedBytes);
        return decodedPassword.equals(password);
    }

}