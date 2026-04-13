import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class java_41847_CredentialValidator_A01 {
    private static final List<String> VALID_DOMAINS = Stream.of("google.com", "facebook.com", "linkedin.com", "apple.com")
            .collect(Collectors.toList());

    public boolean isValid(String domain, X509Certificate certificate) {
        String[] domainParts = domain.split("\\.");
        String[] certParts = certificate.getSubjectDN().split("\\.");

        // Ensure domain and certificate parts have the same number of parts
        if (certParts.length != domainParts.length) {
            return false;
        }

        // Compare domain parts
        for (int i = 0; i < domainParts.length; i++) {
            if (!domainParts[i].equals(certParts[i])) {
                return false;
            }
        }

        // Check if domain is in valid domains
        return VALID_DOMAINS.contains(domain);
    }

    public static void main(String[] args) {
        // Create a fake certificate for testing
        X509Certificate certificate = new X509Certificate("CN=TestCert", "google.com".getBytes(), "SHA1", "MIGfMA0GCSqGSIb3DQEHA...", Arrays.copyOf(new byte[]{1}, 1));

        LegacyCredentialValidator validator = new LegacyCredentialValidator();
        boolean isValid = validator.isValid("google.com", certificate);
        System.out.println("Is valid: " + isValid);
    }
}