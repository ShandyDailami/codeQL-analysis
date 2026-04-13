// UserCredential class java_36792_CredentialValidator_A03 class UserCredential {
    private String username;
    private String password;

    public CredentialValidator(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

// CredentialValidator class
public class CredentialValidator {
    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password";

    public boolean validate(UserCredential credential) {
        if (credential == null) {
            return false;
        }

        String username = credential.getUsername();
        String password = credential.getPassword();

        if (username == null || password == null) {
            return false;
        }

        // The following check is a simplification of an injection attempt, 
        // it should be removed and the program should handle it properly.
        if (username.length() > 10 || password.length() > 20) {
            return false;
        }

        if (!username.equals(VALID_USERNAME) || !password.equals(VALID_PASSWORD)) {
            return false;
        }

        return true;
    }
}

// Example usage
public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        UserCredential credential = new UserCredential("admin", "password");
        boolean isValid = validator.validate(credential);
        System.out.println("Credential is valid: " + isValid);
    }
}