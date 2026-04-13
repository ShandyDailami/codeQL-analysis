import java.security.Provider;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

public class java_08730_CredentialValidator_A03 {
    public static void main(String[] args) {
        // Step 1: Get the list of available security providers
        Provider[] providers = Security.getProviders();

        // Step 2: Iterate over the providers
        for (Provider provider : providers) {
            System.out.println("Provider: " + provider.getName());

            // Step 3: Get a list of the available certificate types
            String[] types = provider.getTypes();

            // Step 4: Iterate over the types
            for (String type : types) {
                System.out.println("Type: " + type);

                // Step 5: Get the certificates for the current type
                Enumeration<X509Certificate> certificates = provider.getCertificates(type);

                // Step 6: Iterate over the certificates
                while (certificates.hasMoreElements()) {
                    X509Certificate certificate = certificates.nextElement();
                    System.out.println("Certificate: " + certificate);

                    // Step 7: Check if the certificate is valid
                    boolean valid = certificate.checkValidity();
                    System.out.println("Is certificate valid? " + valid);
                }
            }
        }
    }
}