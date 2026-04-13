import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

public class java_08201_CredentialValidator_A01 {

    // Method to validate the signature of a credential
    public boolean validateCredential(String credential, PublicKey publicKey, String signature, String expectedHash) throws InvalidKeySpecException {
        byte[] decodedPublicKey = new String(Base64.getDecoder().decode(publicKey)).getBytes();
        byte[] decodedCredential = new String(Base64.getDecoder().decode(credential), "UTF-8").getBytes();
        byte[] signatureBytes = Base64.getDecoder().decode(signature);

        Signature publicSignature = Signature.getInstance("SHA256WithRSA");
        publicSignature.setPublicKey(new RSAKeyPairGenerator().generatePublicKey(new X509EncodedKeySpec(decodedPublicKey)));
        publicSignature.update(decodedCredential);

        return publicSignature.verify(signatureBytes);
    }
}