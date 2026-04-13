import java.security.PublicKey;
import java.security.Signature;
import java.security.Security;
import java.security.InvalidKeyException;
import java.security.SignatureException;

public class java_11079_CredentialValidator_A01 {

    public static boolean validateSignature(PublicKey publicKey, byte[] data, byte[] signature) {
        try {
            Signature sig = Signature.getInstance("SHA1withRSA", Security.getProvider("JavaCrypto"));
            sig.initVerify(publicKey);
            sig.update(data);
            if (!sig.verify(signature)) {
                return false;
            }
        } catch (InvalidKeyException | SignatureException | java.security.NoSuchAlgorithmException ex) {
            return false;
        }
        return true;
    }
}