import java.security.Provider;
import java.security.Security;
import java.util.Enumeration;

public class java_13842_CredentialValidator_A07 {

    public static void main(String[] args) {
        // Get the security providers
        Provider[] providers = Security.getProviders();

        // Print all available providers
        for (Provider provider : providers) {
            System.out.println("Provider: " + provider.getName());

            // Get the algorithms for this provider
            Enumeration<String> algorithms = provider.getAlgorithms();
            while (algorithms.hasMoreElements()) {
                System.out.println("  Algorithm: " + algorithms.nextElement());
            }
        }
    }
}