import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class java_25169_CredentialValidator_A08 {
    // The private key
    private PrivateKey privateKey;

    // Constructor
    public java_25169_CredentialValidator_A08(String privateKeyPEM) throws Exception {
        // Decode the PEM-encoded private key
        byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyPEM);
        PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
        this.privateKey = KeyFactory.getInstance("RSA").generatePrivate(privateKeySpec);
    }

    // Method to validate the signature of a message
    public boolean isValidSignature(String message, String signaturePEM, String publicKeyPEM) throws Exception {
        // Decode the PEM-encoded public key
        byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyPEM);
        X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyBytes);
        PublicKey publicKey = KeyFactory.getInstance("RSA").generatePublic(publicKeySpec);

        // Decode the PEM-encoded signature
        byte[] signatureBytes = Base64.getDecoder().decode(signaturePEM);

        // Verify the signature
        Signature sig = Signature.getInstance("SHA1withRSA");
        sig.initVerify(publicKey);
        sig.update(message.getBytes());

        return sig.verify(signatureBytes);
    }

    public static void main(String[] args) throws Exception {
        // Example usage
        String privateKeyPEM = "-----BEGIN PRIVATE KEY-----...";
        String publicKeyPEM = "-----BEGIN PUBLIC KEY-----...";
        String message = "Hello, World!";
        String signaturePEM = "-----BEGIN SIGNATURE-----...";

        CredentialValidator validator = new CredentialValidator(privateKeyPEM);
        boolean isValid = validator.isValidSignature(message, signaturePEM, publicKeyPEM);

        System.out.println("Signature is valid: " + isValid);
    }
}