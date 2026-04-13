import java.security.InvalidParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

public class java_17083_CredentialValidator_A08 {

    public static boolean validate(String username, String password, String keystorePath, String keystorePassword) {
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password must be provided.");
        }

        if (keystorePath == null || keystorePassword == null) {
            throw new InvalidParameterException("Keystore path and password must be provided.");
        }

        try {
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(getClass().getResourceAsStream(keystorePath), keystorePassword.toCharArray());

            keyStore.getCertificate(username).toString();
            return true;
        } catch (NoSuchAlgorithmException | CertificateException | KeyStoreException | InvalidParameterException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        boolean result = validate("user1", "password1", "keystore.jks", "keystorepassword1");
        System.out.println("Validation result: " + result);
    }
}