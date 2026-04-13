import java.security.Provider;
import java.security.Security;
import java.security.credential.Credential;
import java.security.credential.CredentialProvider;
import java.security.credential.CredentialProviderBrokenException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.util.Set;

public class java_20132_CredentialValidator_A03 {
    public static void main(String[] args) {
        try {
            Set<Provider> providers = Security.getAvailableProviders();
            for (Provider provider : providers) {
                printCredentialProvider(provider);
            }

            CredentialProvider credentialProvider = getFirstCredentialProvider();
            if (credentialProvider != null) {
                printCredentialProvider(credentialProvider);
                try {
                    String password = "password";
                    Credential credential = credentialProvider.getCredential(password.toCharArray(), null);
                    printCredential(credential);
                } catch (CredentialProviderBrokenException e) {
                    e.printStackTrace();
                }
            }
        } catch (InvalidParameterSpecException e) {
            e.printStackTrace();
        }
    }

    private static void printCredentialProvider(Provider provider) {
        System.out.println("Provider: " + provider.getName());
    }

    private static CredentialProvider getFirstCredentialProvider() {
        Set<CredentialProvider> providers = Security.getProviders();
        for (CredentialProvider provider : providers) {
            printCredentialProvider(provider);
            return provider;
        }
        return null;
    }

    private static void printCredential(Credential credential) {
        if (credential instanceof AlgorithmParameterSpec) {
            System.out.println("Algorithm: " + ((AlgorithmParameterSpec) credential).getAlgorithm());
        } else {
            System.out.println("Credential: " + credential.getClass().getName());
        }
    }
}