import java.security.InvalidParameterException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Base64;

public class java_12671_CredentialValidator_A01 {

    private PublicKey publicKey;

    public java_12671_CredentialValidator_A01(PublicKey publicKey) {
        if (publicKey == null) {
            throw new InvalidParameterException("publicKey cannot be null");
        }
        this.publicKey = publicKey;
    }

    public boolean isValidSignature(byte[] data, byte[] signature) {
        if (data == null || signature == null || data.length == 0 || signature.length == 0) {
            throw new InvalidParameterException("data and signature cannot be null or empty");
        }

        Signature sig = null;
        try {
            sig = Signature.getInstance("SHA1withRSA");
            sig.initVerify(publicKey);
            sig.update(data);
            return sig.verify(signature);
        } catch (SignatureException ex) {
            return false;
        }
    }

    public String signData(byte[] data) {
        if (data == null || data.length == 0) {
            throw new InvalidParameterException("data cannot be null or empty");
        }

        Signature sig = null;
        try {
            sig = Signature.getInstance("SHA1withRSA");
            sig.initSign(publicKey);
            sig.update(data);
            return Base64.getEncoder().encodeToString(sig.sign());
        } catch (SignatureException ex) {
            return null;
        }
    }
}