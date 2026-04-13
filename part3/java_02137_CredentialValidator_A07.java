// UserCredentials class java_02137_CredentialValidator_A07 store user's credentials
public class UserCredentials {
    private String username;
    private String password;

    public UserCredentials(String username, String password) {
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

// CredentialValidator interface
public interface CredentialValidator {
    boolean isValid(UserCredentials creds);
}

// CredentialValidatorImpl class that implements CredentialValidator
public class CredentialValidatorImpl implements CredentialValidator {
    private String expectedUsername;
    private String expectedPassword;

    public UserCredentials(String expectedUsername, String expectedPassword) {
        this.expectedUsername = expectedUsername;
        this.expectedPassword = expectedPassword;
    }

    @Override
    public boolean isValid(UserCredentials creds) {
        return creds.getUsername().equals(expectedUsername) && creds.getPassword().equals(expectedPassword);
    }
}

// Main class to test the CredentialValidator
public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidatorImpl("admin", "password");

        UserCredentials creds = new UserCredentials("admin", "password");

        if (validator.isValid(creds)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed!");
        }
    }
}