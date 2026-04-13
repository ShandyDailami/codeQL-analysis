import java.security.PrivateKey;
import java.security.Signature;
import java.util.Base64;

public class java_21114_CredentialValidator_A07 {
    private PrivateKey privateKey;

    public java_21114_CredentialValidator_A07(PrivateKey privateKey) {
        this.privateKey = privateKey;
    }

    public boolean validate(String data, String signatureBase64) throws Exception {
        byte[] dataBytes = data.getBytes();
        byte[] signatureBytes = Base64.getDecoder().decode(signatureBase64);

        Signature signature = Signature.getInstance("SHA1WithRSA");
        signature.initSign(privateKey);
        signature.update(dataBytes);

        byte[] signatureBytesCheck = signature.sign();

        return Arrays.equals(signatureBytes, signatureBytesCheck);
    }
}