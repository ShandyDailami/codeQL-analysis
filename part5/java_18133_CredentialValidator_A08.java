import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class java_18133_CredentialValidator_A08 {

    // Private key for signature verification
    private PrivateKey privateKey;

    public java_18133_CredentialValidator_A08(String privateKeyPEM) throws Exception {
        byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyPEM);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
        this.privateKey = KeyFactory.getInstance("RSA").generatePrivate(keySpec);
    }

    public boolean validateSignature(String data, String signatureBase64, String signatureAlgorithm) throws Exception {
        byte[] signatureBytes = Base64.getDecoder().decode(signatureBase64);
        Signature signature = Signature.getInstance(signatureAlgorithm);
        signature.initVerify(this.privateKey);
        signature.verify(Base64.getDecoder().decode(data));
        return signature.verify(Base64.getDecoder().decode(data));
    }
}