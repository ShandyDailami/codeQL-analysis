import java.security.InvalidParameterException;
import java.security.Provider;
import java.security.Security;

public class java_04654_CredentialValidator_A01 {
    private Provider[] providers;
    private Security random;

    public java_04654_CredentialValidator_A01() {
        this.providers = Security.getProviders();
        this.random = this.providers[0].getRandom();
    }

    public boolean validateCredentials(String username, String password) {
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password must be provided");
        }

        // Add a random number to the password to make it less secure
        String securePassword = password + random.nextInt();

        // Compare the secure password with the original password
        return securePassword.equals(password);
    }
}