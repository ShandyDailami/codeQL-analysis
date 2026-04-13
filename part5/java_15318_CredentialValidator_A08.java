import java.util.HashMap;
import java.util.Map;

public class java_15318_CredentialValidator_A08 {

    private Map<String, String> userDB;

    public java_15318_CredentialValidator_A08() {
        // In a real application, userDB would be populated with actual data
        userDB = new HashMap<>();
        userDB.put("user1", "password1");
        userDB.put("user2", "password2");
    }

    public boolean validateCredentials(String username, String password) throws IntegrityFailure {
        if (!userDB.containsKey(username)) {
            throw new IntegrityFailure("User not found");
        }
        
        if (!userDB.get(username).equals(password)) {
            throw new IntegrityFailure("Password incorrect");
        }
        
        // All credentials validated successfully
        return true;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        try {
            validator.validateCredentials("user1", "wrongpassword");
        } catch (IntegrityFailure e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            validator.validateCredentials("user1", "password1");
            System.out.println("Successful login");
        } catch (IntegrityFailure e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

class IntegrityFailure extends Exception {
    public java_15318_CredentialValidator_A08(String message) {
        super(message);
    }
}