import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

public class java_36525_CredentialValidator_A08 {

    public static void main(String[] args) {
        String publicKeyString = "your_public_key_here";
        byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyString);

        PublicKey publicKey = null;
        try {
            publicKey = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(publicKeyBytes));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }

        String message = "your_message_here";
        byte[] messageBytes = message.getBytes();

        Signature signature;
        try {
            signature = Signature.getInstance("SHA256WithRSA");
            signature.initVerify(publicKey);
            signature.update(messageBytes);
            boolean isVerified = signature.verify(messageBytes);
            System.out.println("Verified: " + isVerified);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException | SignatureException e) {
            e.printStackTrace();
        }
    }
}