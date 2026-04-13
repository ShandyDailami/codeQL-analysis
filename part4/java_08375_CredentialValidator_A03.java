import java.security.Provider;
import java.security.Security;
import java.util.Enumeration;

public class java_08375_CredentialValidator_A03 {
    public static void main(String[] args) {
        // Get the available providers
        Enumeration<Provider> providers = Security.getProviders();

        // Iterate over them
        while (providers.hasMoreElements()) {
            Provider provider = providers.nextElement();
            System.out.println("Provider: " + provider.getName());

            // Get the algorithm mappings
            Enumeration<String> algorithms = provider.getAlgorithms();

            // Iterate over them
            while (algorithms.hasMoreElements()) {
                String algorithm = algorithms.nextElement();
                System.out.println("  Algorithm: " + algorithm);
            }
        }
    }
}