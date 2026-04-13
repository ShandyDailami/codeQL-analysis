import java.security.Provider;
import java.security.Security;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class java_20046_CredentialValidator_A01 {

    // Create an instance of the Security class
    private static final Security SERVICE = Security.getSecurity();

    public static void main(String[] args) {
        try {
            // Create an instance of a provider
            Provider provider = SERVICE.getProvider("SunJSSE");

            // Get a provider instance
            X509Certificate certificate = provider.getCertificate("sample.com");

            // Create a custom validator
            CustomValidator customValidator = new CustomValidator(certificate);

            // Validate the certificate
            boolean isValid = customValidator.validate();

            // Print the result
            System.out.println("Is the certificate valid? " + isValid);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}