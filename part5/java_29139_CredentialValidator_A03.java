import java.security.PublicKey;
import java.security.Signature;
import java.security.Security;
import java.util.Base64;

import javax.crypto.Cipher;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class java_29139_CredentialValidator_A03 {

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    public static boolean isValidSignature(String publicKey, String data, String signature) throws Exception {
        byte[] decodedPublicKey = Base64.getDecoder().decode(publicKey);
        PublicKey publicKeyObj = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decodedPublicKey));

        Signature sig = Signature.getInstance("SHA256WithRSA");
        sig.initVerify(publicKeyObj);
        sig.update(data.getBytes());

        return sig.verify(Base64.getDecoder().decode(signature));
    }

    public static void main(String[] args) {
        String publicKey = "..."; // Replace with your public key
        String data = "..."; // Replace with your data
        String signature = "..."; // Replace with your signature

        try {
            boolean isValid = isValidSignature(publicKey, data, signature);
            System.out.println("Signature is " + (isValid ? "valid" : "not valid"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}