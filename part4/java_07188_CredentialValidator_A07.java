import java.security.Provider;
import java.security.Security;
import java.security.AuthenticationException;

public class java_07188_CredentialValidator_A07 {
    public static void main(String[] args) {
        try {
            Provider provider = Security.getProvider("CustomProvider");
            if (provider != null) {
                // Verify the credentials with the custom provider
                Credential credential = provider.createCredential("username", "password".toCharArray());
                provider.validate(credential);
                System.out.println("Credentials are validated successfully!");
            } else {
                System.out.println("No security provider named 'CustomProvider' found!");
            }
        } catch (AuthenticationException e) {
            System.out.println("Authentication failed with error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}