import java.security.cert.X509Certificate;
import java.util.Arrays;

public class java_21512_CredentialValidator_A01 {
    // Define a static array of trusted Certificate authorities
    private static X509Certificate[] trustedCertificateAuthorities;

    // Constructor to initialize the array
    public java_21512_CredentialValidator_A01() {
        trustedCertificateAuthorities = new X509Certificate[] {};
    }

    // Method to add certificate authorities
    public void addTrustedCertificateAuthority(X509Certificate certificate) {
        trustedCertificateAuthorities = Arrays.copyOf(trustedCertificateAuthorities, trustedCertificateAuthorities.length + 1);
        trustedCertificateAuthorities[trustedCertificateAuthorities.length - 1] = certificate;
    }

    // Method to check if the certificate is trusted
    public boolean isCertificateTrusted(X509Certificate certificate) {
        if (certificate == null) {
            return false;
        }
        if (Arrays.asList(trustedCertificateAuthorities).contains(certificate)) {
            return true;
        }
        return false;
    }

    // Method to validate the credential
    public boolean validateCredential(X509Certificate certificate) {
        if (isCertificateTrusted(certificate)) {
            return true;
        }
        return false;
    }

    // Main method to test the program
    public static void main(String[] args) {
        // Create a new instance of the CredentialValidator class
        CredentialValidator validator = new CredentialValidator();

        // Add a trusted certificate authority
        validator.addTrustedCertificateAuthority(/* provide a trusted certificate here */);

        // Test the validation method
        boolean isValid = validator.validateCredential(/* provide a certificate here */);

        // Print the result
        System.out.println("Is the credential valid? " + (isValid ? "Yes" : "No"));
    }
}