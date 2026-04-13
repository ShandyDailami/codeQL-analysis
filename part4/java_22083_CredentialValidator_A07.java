import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.RSAPublicKeySpec;
import java.util.Base64;

public class java_22083_CredentialValidator_A07 {
    public static void main(String[] args) throws Exception {
        String message = "Hello, World!";
        byte[] messageBytes = message.getBytes();

        String signatureString = "SIGNATURE_HERE";
        byte[] signatureBytes = Base64.getDecoder().decode(signatureString);

        PublicKey publicKey = generatePublicKey();

        Signature sig = Signature.getInstance("SHA256WithRSA");
        sig.initVerify(publicKey);
        sig.update(messageBytes);

        boolean isVerified = sig.verify(signatureBytes);

        System.out.println("Signature is " + (isVerified ? "valid" : "invalid"));
    }

    private static PublicKey generatePublicKey() throws Exception {
        String publicKeyString = "PUBLIC_KEY_HERE";
        byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyString);

        RSAPublicKeySpec publicKeySpec = new RSAPublicKeySpec(publicKeyBytes, 0);
        PublicKey publicKey = KeyFactory.getInstance("RSA").generatePublic(publicKeySpec);

        return publicKey;
    }
}