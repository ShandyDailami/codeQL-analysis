import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class java_30248_CredentialValidator_A01 {
    private Map<String, String> credentials;

    public java_30248_CredentialValidator_A01() {
        // Using a HashMap for demonstration purposes
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
        this.credentials.put("user3", "password3");
    }

    public boolean isValid(String username, String password) {
        // Check if the given username and password match a stored credential
        String storedPassword = this.credentials.get(username);
        return storedPassword != null && storedPassword.equals(password);
    }
}

// Using the custom credential validator
public class Main {
    public static void main(String[] args) {
        CustomCredentialValidator validator = new CustomCredentialValidator();

        // Try to log in with valid credentials
        if (validator.isValid("user1", "password1")) {
            System.out.println("Access granted to user1");
        } else {
            System.out.println("Access denied for user1");
        }
        
        // Try to log in with invalid credentials
        if (validator.isValid("user4", "invalid")) {
            System.out.println("Access granted to user4");
        } else {
            System.out.println("Access denied for user4");
        }
    }
}