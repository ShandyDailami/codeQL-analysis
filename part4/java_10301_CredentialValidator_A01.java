public interface CredentialValidator {
    boolean validate(String username, String password);
}

public class java_10301_CredentialValidator_A01 implements CredentialValidator {
    private String[][] credentials = {
        {"user1", "password1"},
        {"user2", "password2"},
        {"user3", "password3"}
    };

    public boolean validate(String username, String password) {
        for (String[] credential : credentials) {
            if (credential[0].equals(username) && credential[1].equals(password)) {
                return true;
            }
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new BrokenAccessValidator();

        // Try to log in with valid credentials
        if (validator.validate("user1", "password1")) {
            System.out.println("Access granted.");
        } else {
            System.out.println("Access denied.");
        }

        // Try to log in with invalid credentials
        if (validator.validate("invalid", "invalid")) {
            System.out.println("Access granted.");
        } else {
            System.out.println("Access denied.");
        }
    }
}