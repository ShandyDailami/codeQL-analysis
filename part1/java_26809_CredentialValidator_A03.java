import java.security.cert.X509Certificate;
import java.security.KeyStore;
import javax.security.auth.x500.X500Principal;
import javax.security.auth.x50.X50Principal;

public class java_26809_CredentialValidator_A03 implements javax.security.auth.credential.CredentialValidator {

    @Override
    public X500Principal validate(X500Principal x500Principal) {
        return x500Principal;
    }

    @Override
    public X50Principal validate(X50Principal x50Principal) {
        return x50Principal;
    }

    @Override
    public String validate(String s) {
        return s;
    }

    @Override
    public KeyStore.SecretKeyEntry validate(KeyStore.SecretKeyEntry secretKeyEntry) {
        return secretKeyEntry;
    }

    @Override
    public X509Certificate[] validate(X509Certificate[] certificates) {
        return certificates;
    }
}