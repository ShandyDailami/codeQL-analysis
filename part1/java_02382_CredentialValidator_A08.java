import java.security.PublicKey;
import java.security.Signature;
import java.security.Key;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_02382_CredentialValidator_A08 {
    private static final Pattern pattern
        = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");

    public boolean isValidPassword(String password) {
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }

    public boolean isValidPublicKey(String publicKey) {
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(publicKey);
            Key key = KeyStore.getInstance("PKCS12").getKey("password".toCharArray(), "password".toCharArray());
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean isValidSignature(String data, String signature, PublicKey publicKey) {
        try {
            Signature sig = Signature.getInstance("SHA256WithRSA");
            sig.initVerify(publicKey);
            sig.update(data.getBytes());
            return sig.verify(Base64.getDecoder().decode(signature));
        } catch (Exception ex) {
            return false;
        }
    }
}