import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class java_40801_CredentialValidator_A07 {
    public boolean validateCredential(String publicKeyBase64, String signatureBase64, String data) {
        try {
            PublicKey publicKey = KeyUtils.getPublicKey(publicKeyBase64);
            byte[] dataBytes = data.getBytes();
            byte[] signatureBytes = Base64.getDecoder().decode(signatureBase64);

            Signature signature = Signature.getInstance("SHA1withRSA");
            signature.initVerify(publicKey);
            signature.update(dataBytes);

            return signature.verify(signatureBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

class KeyUtils {
    public static PublicKey getPublicKey(String publicKeyBase64) throws InvalidKeySpecException {
        byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyBase64);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(keySpec);
    }
}