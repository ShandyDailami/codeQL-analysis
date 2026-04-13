import java.security.PublicKey;
import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;

public class java_09081_CredentialValidator_A01 implements javax.security.auth.credential.CredentialValidator {

    @Override
    public boolean validate(X509Certificate cert) {
        // This method is empty, we'll use the default implementation
        return true;
    }

    @Override
    public boolean validate(PublicKey key) {
        // This method is also empty, we'll use the default implementation
        return true;
    }

    @Override
    public boolean validate(X500Principal x500Principal) {
        // This method is also empty, we'll use the default implementation
        return true;
    }

    @Override
    public boolean validate(javax.security.auth.Subject subject) {
        // This method is also empty, we'll use the default implementation
        return true;
    }

    @Override
    public boolean validate(javax.security.auth.TransportAddress address) {
        // This method is also empty, we'll use the default implementation
        return true;
    }

}