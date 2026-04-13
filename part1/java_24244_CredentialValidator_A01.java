import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class java_24244_CredentialValidator_A01 {

    public static boolean validate(String data, String signature, String publicKey) throws Exception {
        byte[] decodedPublicKey = Base64.getDecoder().decode(publicKey);
        byte[] decodedSignature = Base64.getDecoder().decode(signature);
        
        PrivateKey priKey = new PKCS8EncodedKeySpec(decodedPublicKey);
        Signature sig = Signature.getInstance("SHA1withRSA");
        sig.initVerify(priKey);
        sig.update(data.getBytes());
        return sig.verify(decodedSignature);
    }

}