import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.X509Certificate;

public class java_36482_CredentialValidator_A07 {

    // Method to validate the credential
    public boolean validateCredential(PublicKey publicKey, String credential, X509Certificate certificate) {
        try {
            Signature signature = Signature.getInstance("SHA1withRSA");
            signature.initVerify(certificate);
            signature.verify(Base64.getDecoder().decode(credential));
            return true;
        } catch (Exception e) {
            System.out.println("Credential validation failed due to: " + e.getMessage());
            return false;
        }
    }
}