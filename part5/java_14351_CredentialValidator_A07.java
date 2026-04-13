import java.util.HashMap;

public class java_14351_CredentialValidator_A07 {
    private HashMap<String, String> userCredentials;

    public java_14351_CredentialValidator_A07() {
        userCredentials = new HashMap<>();
        userCredentials.put("user1", "password1");
        userCredentials.put("user2", "password2");
        userCredentials.put("user3", "password3");
    }

    public boolean validateCredentials(String user, String password) {
        if (userCredentials.containsKey(user) && userCredentials.get(user).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // User 1
        if (validator.validateCredentials("user1", "password1")) {
            System.out.println("Access granted for user1.");
        } else {
            System.out.println("Access denied for user1.");
        }

        // User 2
        if (validator.validateCredentials("user2", "password2")) {
            System.out.println("Access granted for user2.");
        } else {
            System.out.println("Access denied for user2.");
        }

        // User 3
        if (validator.validateCredentials("user3", "password3")) {
            System.out.println("Access granted for user3.");
        } else {
            System.out.println("Access denied for user3.");
        }
    }
}