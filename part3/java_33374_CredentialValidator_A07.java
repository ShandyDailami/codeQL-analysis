import java.util.HashMap;
import java.util.Map;

public class java_33374_CredentialValidator_A07 {
    private Map<String, String> userDB;

    public java_33374_CredentialValidator_A07() {
        userDB = new HashMap<>();
        userDB.put("user1", "password1");
        userDB.put("user2", "password2");
        userDB.put("user3", "password3");
    }

    public boolean validate(String username, String password) {
        if (userDB.containsKey(username) && userDB.get(username).equals(password)) {
            System.out.println("User has validated successfully.");
            return true;
        } else {
            System.out.println("Invalid username or password.");
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Validate with correct credentials
        validator.validate("user1", "password1");

        // Validate with incorrect credentials
        validator.validate("user4", "wrongpassword");
    }
}