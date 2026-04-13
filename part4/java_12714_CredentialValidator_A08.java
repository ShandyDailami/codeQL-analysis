import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Base64;

public class java_12714_CredentialValidator_A08 {

    private PublicKey publicKey;

    public java_12714_CredentialValidator_A08(PublicKey publicKey) {
        this.publicKey = publicKey;
    }

    public boolean isValidSignature(String data, String signatureBase64, String signaturePublicKeyBase64) throws SignatureException {
        byte[] dataBytes = data.getBytes();
        byte[] signatureBytes = Base64.getDecoder().decode(signatureBase64);
        byte[] publicKeyBytes = Base64.getDecoder().decode(signaturePublicKeyBase64);

        Key key = new KeyImpl(publicKeyBytes);

        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initVerify(key);
        signature.verify(signatureBytes);

        return signature.verify(signatureBytes);
    }
}