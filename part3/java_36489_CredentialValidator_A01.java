import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_36489_CredentialValidator_A01 {
    // In a real-world application, this would be a method that fetches the user's credentials from a database
    private Map<String, String> credentials = new HashMap<>();

    public java_36489_CredentialValidator_A01() {
        // Initialize the credentials map
        credentials.put("admin", Base64.getEncoder().encodeToString("admin:admin".getBytes()));
        credentials.put("user", Base64.getEncoder().encodeToString("user:user".getBytes()));
    }

    public boolean validate(String username, String password) {
        // Decode the password and check it against the database
        String decodedPassword = new String(Base64.getDecoder().decode(credentials.get(username)));
        return password.equals(decodedPassword);
    }
}

public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        String username = "admin";
        String password = "admin";

        if (validator.validate(username, password)) {
            System.out.println("Access granted for user: " + username);
        } else {
            System.out.println("Access denied for user: " + username);
        }
    }
}