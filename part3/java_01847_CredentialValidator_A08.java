import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class java_01847_CredentialValidator_A08 {
    public static boolean verifyCredentials(PublicKey publicKey, byte[] signature, String data) {
        try {
            Signature sig = Signature.getInstance("SHA1withRSA");
            sig.initVerify();
            sig.update(data.getBytes());

            if (!sig.verify(publicKey)) {
                return false;
            }

            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static PublicKey getPublicKey(byte[] keyBytes) {
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        try {
            PublicKey publicKey = keySpec.getPublicKey();
            return publicKey;
        } catch (InvalidKeySpecException ex) {
            return null;
        }
    }

    public static PrivateKey getPrivateKey(byte[] keyBytes) {
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        try {
            PrivateKey privateKey = keySpec.getPrivateKey();
            return privateKey;
        } catch (InvalidKeySpecException ex) {
            return null;
        }
    }
}