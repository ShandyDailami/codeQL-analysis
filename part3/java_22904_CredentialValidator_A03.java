import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;

public class java_22904_CredentialValidator_A03 {

    public boolean isValidCertificate(X509Certificate cert) throws GeneralSecurityException {
        // Replace this with your own logic.
        // This is a placeholder and will always return true.
        return true;
    }

    public boolean isValidCredential(X509Certificate[] chain, String authType) throws GeneralSecurityException {
        if (chain == null || chain.length == 0) {
            throw new GeneralSecurityException("Chain is null or empty.");
        }

        X509Certificate cert = chain[chain.length - 1];

        if (!isValidCertificate(cert)) {
            throw new GeneralSecurityException("Invalid certificate.");
        }

        // This is a placeholder and will always return true.
        return true;
    }

    public static void main(String[] args) {
        // Create a new instance of the LegacyVanillaCredentialValidator class
        LegacyVanillaCredentialValidator validator = new LegacyVanillaCredentialValidator();

        // Test the isValidCredential method with some sample data
        try {
            X509Certificate[] chain = null;  // Replace with your own certificate chain
            String authType = null;  // Replace with your own authentication type

            if (!validator.isValidCredential(chain, authType)) {
                System.out.println("Invalid credential.");
            } else {
                System.out.println("Valid credential.");
            }
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
    }
}