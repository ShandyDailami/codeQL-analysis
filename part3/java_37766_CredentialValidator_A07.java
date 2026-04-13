import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class java_37766_CredentialValidator_A07 {
    // Signature method for the custom credential validator
    public boolean validateSignature(byte[] data, byte[] signature, PrivateKey privateKey) {
        try {
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKey.getEncoded());
            Signature signatureInstance = Signature.getInstance("SHA256WithRSA");
            signatureInstance.initSign(keySpec);
            signatureInstance.update(data);
            byte[] signatureBytes = signatureInstance.sign();

            return new String(Base64.getEncoder().encode(signatureBytes)).equals(new String(Base64.getEncoder().encode(signature)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}