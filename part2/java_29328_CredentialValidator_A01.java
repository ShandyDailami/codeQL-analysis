// CredentialValidator interface
public interface CredentialValidator {
    User validate(String username, String password);
}

// User class java_29328_CredentialValidator_A01 class User {
    private String username;
    private String password;

    public SecuritySystem(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // getters and setters omitted for brevity
}

// CredentialValidator implementation using a hypothetical security system
public class SecuritySystem {
    public User validateUser(String username, String password) {
        // This is a hypothetical validation. In a real-world application, you would
        // likely interact with your security system to validate the username and password.
        // This could involve a database call, a network call, etc.

        if (username.equals("admin") && password.equals("password")) {
            return new User(username, password);
        } else {
            return null;
        }
    }
}

public class CredentialValidatorImpl implements CredentialValidator {
    private SecuritySystem securitySystem;

    public SecuritySystem(SecuritySystem securitySystem) {
        this.securitySystem = securitySystem;
    }

    @Override
    public User validate(String username, String password) {
        return securitySystem.validateUser(username, password);
    }
}