import java.util.HashMap;
import java.util.Map;

public class java_11322_CredentialValidator_A07 {
    private Map<String, String> users;

    public java_11322_CredentialValidator_A07() {
        users = new HashMap<>();
        users.put("admin", "password");
    }

    public boolean isValid(String username, String password) {
        if (!users.containsKey(username)) {
            System.out.println("Invalid username");
            return false;
        }

        if (!users.get(username).equals(password)) {
            System.out.println("Invalid password");
            return false;
        }

        System.out.println("Authentication successful");
        return true;
    }
}