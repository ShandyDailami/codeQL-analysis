import java.util.HashMap;
import java.util.Map;

public class java_28450_CredentialValidator_A08 {

    private Map<String, String> userMap;

    public java_28450_CredentialValidator_A08() {
        userMap = new HashMap<>();
        userMap.put("user1", "password1");
        userMap.put("user2", "password2");
        userMap.put("user3", "password3");
    }

    public boolean validateCredentials(String user, String password) {
        if (userMap.containsKey(user) && userMap.get(user).equals(password)) {
            System.out.println("Login successful for user: " + user);
            return true;
        } else {
            System.out.println("Invalid username or password for user: " + user);
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.validateCredentials("user1", "password1");
        validator.validateCredentials("user2", "wrongpassword");
        validator.validateCredentials("user4", "password4");
    }
}