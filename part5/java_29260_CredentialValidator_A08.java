import java.util.HashMap;
import java.util.Map;

// Interface to encrypt passwords
interface PasswordEncryptor {
    String encrypt(String password);
}

// Interface to authenticate passwords
interface PasswordAuthenticator {
    boolean authenticate(String username, String password);
}

public class java_29260_CredentialValidator_A08 {
    private PasswordEncryptor passwordEncryptor;
    private PasswordAuthenticator passwordAuthenticator;

    // Creating a map to store credentials
    private Map<String, String> credentials;

    public java_29260_CredentialValidator_A08() {
        this.passwordEncryptor = new PasswordEncryptor() {
            @Override
            public String encrypt(String password) {
                // This is a simple example of encrypting passwords. In a real application, you would want to use a more secure method of encryption.
                return password + "_encrypted";
            }
        };

        this.passwordAuthenticator = new PasswordAuthenticator() {
            @Override
            public boolean authenticate(String username, String password) {
                // This is a simple example of authenticating passwords. In a real application, you would want to use a more secure method of authentication.
                return username.equals("user") && password.equals("password");
            }
        };

        // Initialize credentials map
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public String encryptPassword(String password) {
        return passwordEncryptor.encrypt(password);
    }

    public boolean authenticate(String username, String password) {
        String encryptedPassword = this.credentials.get(username);
        if (encryptedPassword == null) {
            return false;
        }
        String decryptedPassword = this.encryptPassword(encryptedPassword);
        return passwordAuthenticator.authenticate(username, decryptedPassword);
    }
}