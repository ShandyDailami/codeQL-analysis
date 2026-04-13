import java.security.Provider;
import java.security.Security;
import java.util.Enumeration;

public class java_09624_CredentialValidator_A01 {
    public static void main(String[] args) {
        // Get the security providers
        Provider[] providers = Security.getProviders();

        // Print out all providers
        for (Provider provider : providers) {
            System.out.println("Provider: " + provider.getName());
        }

        // Get the CredentialValidators
        Enumeration<Provider.Service> services = provider.getServices();
        while (services.hasMoreElements()) {
            Provider.Service service = services.nextElement();
            if (service.getType().equals("CredentialValidator")) {
                try {
                    CredentialValidator validator = (CredentialValidator) service.getService(provider);
                    System.out.println("CredentialValidator found: " + validator.getClass().getName());
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
    }
}