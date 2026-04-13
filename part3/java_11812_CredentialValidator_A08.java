import java.security.InvalidParameterException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Base64;

public class java_11812_CredentialValidator_A08 {

    private static final String ALGORITHM = "SHA1PRIVATEKEY";

    public boolean isValidSignature(byte[] data, byte[] signature, PrivateKey privateKey) {
        try {
            Signature sig = Signature.getInstance(ALGORITHM);
            sig.initVerify();
            sig.verify(signature);
            sig.update(data);
            return sig.verify(signature);
        } catch (SignatureException | InvalidParameterException e) {
            return false;
        }
    }
}