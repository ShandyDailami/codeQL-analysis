import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class java_03206_CredentialValidator_A03 {
    private List<String> validDomains;

    public java_03206_CredentialValidator_A03() {
        validDomains = new ArrayList<>(Arrays.asList("example.com", "test.com"));
    }

    public boolean validate(String domain) {
        return validDomains.contains(domain);
    }

    public static void main(String[] args) {
        CustomCredentialValidator validator = new CustomCredentialValidator();

        // Test valid domains
        System.out.println("Is 'example.com' valid? " + validator.validate("example.com"));
        System.out.println("Is 'test.com' valid? " + validator.validate("test.com"));

        // Test invalid domains
        System.out.println("Is 'invalid.com' valid? " + validator.validate("invalid.com"));
    }
}