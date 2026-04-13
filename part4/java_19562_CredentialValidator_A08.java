import java.security.PublicKey;
import java.security.Signature;
import java.security.InvalidKeyException;
import java.security.SignatureException;
import java.util.Base64;

public class java_19562_CredentialValidator_A08 {
    public static boolean validateSignature(PublicKey publicKey, String data, String signature) throws SignatureException, InvalidKeyException {
        byte[] signatureBytes = Base64.getDecoder().decode(signature);
        Signature signatureInstance = Signature.getInstance("SHA1withRSA");
        signatureInstance.initVerify(publicKey);
        signatureInstance.update(data.getBytes());
        return signatureInstance.verify(signatureBytes);
    }
}