// Imports
import java.util.Objects;

// User Credentials Class
public class java_40737_CredentialValidator_A01 {
    private String username;
    private String password;

    public java_40737_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Overriding equals and hashCode to use in a hashMap
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCredentials that = (UserCredentials) o;
        return Objects.equals(username, that.username) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }
}

// Credential Validator Interface
interface CredentialValidator {
    boolean validate(UserCredentials userCredentials);
}

// Basic Credential Validator Class
public class BasicCredentialValidator implements CredentialValidator {
    private final String correctUsername = "user";
    private final String correctPassword = "password";

    @Override
    public boolean validate(UserCredentials userCredentials) {
        return userCredentials.getUsername().equals(correctUsername) && userCredentials.getPassword().equals(correctPassword);
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {
        UserCredentials userCredentials = new UserCredentials("user", "password");
        BasicCredentialValidator validator = new BasicCredentialValidator();
        
        if (validator.validate(userCredentials)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}