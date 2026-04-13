import java.security.PublicKey;
import java.security.Signature;
import java.security.Security;

public class java_02553_CredentialValidator_A08 {

    static {
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
    }

    public boolean validate(PublicKey publicKey, byte[] signature, byte[] data) throws Exception {
        Signature sig = Signature.getInstance("SHA1withRSA", "BC");
        sig.initVerify(publicKey);
        sig.update(data);
        return sig.verify(signature);
    }
}