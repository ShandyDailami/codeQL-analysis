// Import necessary classes
import java.util.Base64;
import java.util.UUID;

// Define the CredentialValidator interface
interface CredentialValidator {
    boolean validate(String username, String password);
}

// Define the UserAccount class java_32268_CredentialValidator_A08 UserAccount {
    private String username;
    private String password;

    // Constructor
    public TestCredentialValidator(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter and Setter methods
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

// Define the CredentialValidatorImpl class
class CredentialValidatorImpl implements CredentialValidator {
    // In-memory storage of user accounts
    private static UserAccount[] userAccounts = new UserAccount[1];
    private static int currentIndex = 0;

    // Method to add a user account
    public static void addUserAccount(UserAccount userAccount) {
        userAccounts[currentIndex++] = userAccount;
    }

    // Validate the credentials
    public boolean validate(String username, String password) {
        for (UserAccount userAccount : userAccounts) {
            if (userAccount.getUsername().equals(username) && userAccount.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}

// Test the CredentialValidatorImpl class
public class TestCredentialValidator {
    public static void main(String[] args) {
        // Add a user account
        CredentialValidatorImpl.addUserAccount(new UserAccount("test", "test"));

        // Validate the credentials
        System.out.println(CredentialValidatorImpl.validate("test", "test")); // Should print: true
        System.out.println(CredentialValidatorImpl.validate("test", "wrong")); // Should print: false
    }
}