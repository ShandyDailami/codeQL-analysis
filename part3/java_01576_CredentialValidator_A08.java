import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.X509Certificate;

public class java_01576_CredentialValidator_A08 {

    private PublicKey publicKey;

    public java_01576_CredentialValidator_A08(PublicKey publicKey) {
        this.publicKey = publicKey;
    }

    public boolean isValidSignature(byte[] data, byte[] signature) {
        try {
            Signature sig = Signature.getInstance("SHA256WithRSA");
            sig.initVerify(publicKey);
            sig.update(data);
            if (!sig.verify(signature)) {
                System.out.println("Invalid signature!");
                return false;
            }
            System.out.println("Valid signature!");
            return true;
        } catch (SignatureException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isValidCertificate(X509Certificate certificate) {
        // You could check the certificate here, for example if it is expired or self-signed
        return true; // In a real-world scenario, you would probably check these on a server.
    }
}