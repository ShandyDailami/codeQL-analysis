import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;

public class java_35224_CredentialValidator_A08 {

    // Method to check if the credential is valid
    public boolean validate(PublicKey publicKey, byte[] signature, byte[] content) {
        Signature signatureObj = null;
        try {
            signatureObj = Signature.getInstance("SHA1withRSA");
            signatureObj.initVerify(publicKey);
            signatureObj.update(content);
            return signatureObj.verify(signature);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}