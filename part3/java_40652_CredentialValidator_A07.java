import java.security.Provider;
import java.security.Security;
import java.security.credential.Credential;
import java.security.credential.CredentialException;
import java.security.spec.InvalidParameterSpecException;

public class java_40652_CredentialValidator_A07 {

    public static void main(String[] args) {
        // Create a provider instance
        Provider provider = Security.getProvider("S");

        // Create a credential instance
        Credential credential = provider.getCredential("username", "password".toCharArray());

        // Validate the credential
        try {
            credential.validate(null);
        } catch (CredentialException e) {
            System.out.println("Invalid credentials");
        }
    }

}