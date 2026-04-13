import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;

public class java_07814_CredentialValidator_A01 {

    private static final List<String> ALLOWED_ORGANIZATIONS = Arrays.asList("Alice", "Bob", "Charlie");

    public boolean isValidCertificate(X509Certificate certificate) {
        String organization = certificate.getSubjectDN().get([Organization]);
        return ALLOWED_ORGANIZATIONS.contains(organization);
    }

    public static void main(String[] args) {
        // Add your code here
    }
}