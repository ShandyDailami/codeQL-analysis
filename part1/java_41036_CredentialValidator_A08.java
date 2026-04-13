import java.security.Credentials;
import java.security.GeneralSecurityException;
import java.security.AccessControlException;

public class java_41036_CredentialValidator_A08 {
    private String username;
    private String password;

    public java_41036_CredentialValidator_A08(String username, String password) {
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

public class LegacyCredentialValidator implements java.security.CredentialValidator {
    private User user;

    public java_41036_CredentialValidator_A08(User user) {
        this.user = user;
    }

    @Override
    public Credentials validate(Credentials credentials) throws GeneralSecurityException {
        String providedUsername = credentials.getIdentifier();
        String providedPassword = new String(credentials.getPassword());

        if (user.getUsername().equals(providedUsername) && user.getPassword().equals(providedPassword)) {
            return credentials;
        } else {
            throw new AccessControlException("Access is denied");
        }
    }

    @Override
    public String getValidationQuery() {
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        User user = new User("admin", "password");
        LegacyCredentialValidator validator = new LegacyCredentialValidator(user);

        // In a Legacy system, you would usually check the user's credentials against a real database
        // Here, we are just checking that the user is who we think they are
        try {
            validator.validate(new java.security.credential.UsernamePasswordCredentials("admin", "password"));
            System.out.println("Access granted");
        } catch (AccessControlException e) {
            System.out.println("Access denied");
        }
    }
}