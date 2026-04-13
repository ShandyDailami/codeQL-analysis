import java.security.InvalidParameterException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import javax.security.auth.login.CredentialNotFoundException;

public class java_39512_CredentialValidator_A07 {

    private String publicKeyString;

    public java_39512_CredentialValidator_A07(String publicKeyString) {
        this.publicKeyString = publicKeyString;
    }

    public boolean isValidSignature(String data, String signatureString) {
        try {
            byte[] signatureBytes = Base64.getDecoder().decode(signatureString);
            byte[] dataBytes = data.getBytes();
            PublicKey publicKey = getPublicKey(this.publicKeyString);

            Signature signature = Signature.getInstance("SHA1withRSA");
            signature.initVerify(publicKey);
            signature.update(dataBytes);

            return signature.verify(signatureBytes);
        } catch (Exception e) {
            throw new CredentialNotFoundException("Invalid signature", e);
        }
    }

    private PublicKey getPublicKey(String publicKeyString) {
        try {
            byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyString);
            return new X509EncodedKeySpec(publicKeyBytes);
        } catch (Exception e) {
            throw new InvalidParameterException("Invalid public key", e);
        }
    }
}