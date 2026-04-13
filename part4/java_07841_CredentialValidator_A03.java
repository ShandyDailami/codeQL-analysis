import java.security.Provider;
import java.security.Security;
import java.security.cert.Certificate;

public class java_07841_CredentialValidator_A03 {

    public static void main(String[] args) {
        // Step 1: Fetch the Security Provider
        Provider[] providers = Security.getProviders();
        for (Provider provider : providers) {
            System.out.println("Security Provider: " + provider.getName());
            // Fetch certificate chains
            Certificate[] certificates = provider.getCertificateChain("myDomain");
            if (certificates != null && certificates.length > 0) {
                Certificate certificate = certificates[0];
                System.out.println("Certificate: " + certificate.toString());
            }
        }
    }
}