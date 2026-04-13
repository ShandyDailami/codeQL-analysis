import java.security.Provider;
import java.security.Security;
import java.security.credential.Credential;
import java.security.credential.CredentialProvider;
import java.security.credential.CredentialProviderBrokenException;
import java.security.spec.AlgorithmParameterSpec;

public class java_06489_CredentialValidator_A07 {

    public static void main(String[] args) {
        Provider[] providers = Security.getProviders();
        for (Provider provider : providers) {
            System.out.println(provider.getName());
            CredentialProvider credentialProvider = provider.getCredentialProvider("UserCredential");
            if (credentialProvider != null) {
                try {
                    Credential credential = credentialProvider.createCredential("password");
                    validatePassword(credential);
                } catch (CredentialProviderBrokenException e) {
                    System.out.println("Provider broken: " + e.getMessage());
                }
            }
        }
    }

    private static void validatePassword(Credential credential) {
        try {
            String password = (String) credential.getCredential();
            if (password.length() > 8) {
                if (password.matches(".*[A-Z].*")) {
                    System.out.println("Password is valid: " + password);
                } else {
                    System.out.println("Password is not valid: " + password);
                }
            } else {
                System.out.println("Password length is not valid: " + password);
            }
        } catch (Exception e) {
            System.out.println("Error validating password: " + e.getMessage());
        }
    }
}