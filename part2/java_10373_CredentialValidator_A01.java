import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class java_10373_CredentialValidator_A01 {
    private PrivateKey privateKey;

    public java_10373_CredentialValidator_A01(String privateKeyBase64) throws Exception {
        byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyBase64);
        this.privateKey = new PrivateKeySpec(privateKeyBytes, "RSA");
    }

    public boolean isValidSignature(String signatureBase64, String dataBase64) throws Exception {
        byte[] signatureBytes = Base64.getDecoder().decode(signatureBase64);
        byte[] dataBytes = Base64.getDecoder().decode(dataBase64);

        Signature sig = Signature.getInstance("SHA256WithRSA");
        sig.initVerify(this.privateKey);
        sig.update(dataBytes);

        return sig.verify(signatureBytes);
    }
}