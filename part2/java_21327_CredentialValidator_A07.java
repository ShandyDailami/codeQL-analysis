import java.security.GeneralSecurityException;
import java.security.credential.Credential;
import java.security.credential.UsernamePasswordCredentials;
import java.security.credential.CredentialContext;

public class java_21327_CredentialValidator_A07 {
    public static void main(String[] args) {
        try {
            // Create a credential context
            CredentialContext credentialContext = new CredentialContext();

            // Add a credential to the context
            Credential credential = new UsernamePasswordCredentials("user", "password");
            credentialContext.setCredential(credential);

            // Validate the credential
            if (credentialContext.validate()) {
                System.out.println("Credential is valid.");
            } else {
                System.out.println("Credential is not valid.");
            }
        } catch (GeneralSecurityException e) {
            System.out.println("Error validating credential: " + e.getMessage());
        }
    }
}