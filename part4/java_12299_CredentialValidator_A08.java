import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.X509Certificate;

import javax.security.auth.x500.X500Principal;

public class java_12299_CredentialValidator_A08 {
    public boolean validate(PublicKey publicKey, X509Certificate certificate, String data) {
        try {
            Signature signature = Signature.getInstance("SHA1withRSA");
            signature.initVerify(publicKey);
            signature.update(data.getBytes());
            return signature.verify(certificate.getSignature());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}