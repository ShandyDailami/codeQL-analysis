import java.security.Provider;
import java.security.Security;
import java.util.Base64;

public class java_40228_CredentialValidator_A07 {

    public static void main(String[] args) {

        // Create a new Security provider.
        Provider provider = Security.getProvider("Sun");
        Security.addProvider(provider);

        // Create an instance of CredentialValidator.
        CredentialValidator credentialValidator = provider.getCredentialValidator("PBKDF2WithHmacSHA1");

        // Create an instance of Credential.
        Credential credential = new Credential("user", "password".getBytes());

        // Validate the Credential.
        validateCredential(credentialValidator, credential);
    }

    private static void validateCredential(CredentialValidator validator, Credential credential) {

        try {
            // Validate the Credential.
            validator.validate(credential);
            System.out.println("Credential is valid.");
        } catch (Exception e) {
            System.out.println("Credential is not valid: " + e.getMessage());
        }
    }
}