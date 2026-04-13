import java.security.Provider;
import java.security.Security;
import java.security.credential.Credential;
import java.security.credential.CredentialProvider;
import java.security.credential.CredentialProviderBroker;

public class java_09426_CredentialValidator_A07 {
    public static void main(String[] args) {
        // Create a CredentialProviderBroker that can provide CredentialProviders
        Provider[] providers = Security.getProviders();
        CredentialProviderBroker broker = (CredentialProviderBroker) providers[0];

        // Create a CredentialProvider that provides Credentials
        CredentialProvider provider = broker.getCredentialProvider("password.policy.example");

        // Create a CredentialValidator
        CredentialValidator validator = provider.getCredentialValidator("password.policy.example");

        // Test the CredentialValidator
        String password = "short";
        testValidator(validator, password);

        password = "SHORT";
        testValidator(validator, password);

        password = "short";
        testValidator(validator, password);
    }

    private static void testValidator(CredentialValidator validator, String password) {
        try {
            validator.validate(new Credential(password));
            System.out.println("Password is valid: " + password);
        } catch (Exception e) {
            System.out.println("Password is not valid: " + password);
        }
    }
}