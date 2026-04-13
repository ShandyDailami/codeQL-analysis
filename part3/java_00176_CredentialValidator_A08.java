import java.security.InvalidParameterException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;

public class java_00176_CredentialValidator_A08 {

    private PublicKey publicKey;

    public java_00176_CredentialValidator_A08(PublicKey publicKey) {
        if (publicKey == null) {
            throw new InvalidParameterException("Public key cannot be null");
        }
        this.publicKey = publicKey;
    }

    public boolean validate(Certificate credential) {
        if (credential == null) {
            throw new InvalidParameterException("Credential cannot be null");
        }

        try {
            credential.getPublicKey().verify(credential.getSignature());
            return true;
        } catch (CertificateException | NoSuchMethodException e) {
            return false;
        }
    }

}