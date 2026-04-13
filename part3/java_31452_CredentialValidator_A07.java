import java.security.Key;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import javax.security.auth.login.LoginException;
import javax.security.auth.x500.X500Principal;

public class java_31452_CredentialValidator_A07 {
    public boolean validate(KeyStore keyStore, String keyStorePassword,
                           String certificatePassword, String certificateAlias) throws Exception {
        try {
            // Get certificate and private key
            Certificate certificate = keyStore.getCertificate(certificateAlias);
            Key key = certificate.getKey();

            // Validate certificate
            X500Principal x500 = new X500Principal(((Certificate)certificate).getSubjectX500Principal());
            if (!x500.getIssuerX500Principal().equals(x500.getSubjectX500Principal())) {
                System.out.println("Issuer and Subject X500 mismatch!");
                return false;
            }

            // Validate private key
            if (!((PrivateKey)key).getAlgorithm().equals(keyStore.getKey(certificateAlias, certificatePassword.toCharArray()).getAlgorithm())) {
                System.out.println("Private key algorithm mismatch!");
                return false;
            }

            // All checks passed
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}