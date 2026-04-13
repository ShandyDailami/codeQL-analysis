import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;

public class java_39124_CredentialValidator_A08 {

    private KeyStore keyStore;

    public java_39124_CredentialValidator_A08() throws KeyStoreException, CertificateException {
        // Load the KeyStore containing your credentials
        keyStore = KeyStore.getInstance("JKS");
        keyStore.load(getClass().getResourceAsStream("credentials.jks"), "password".toCharArray());
    }

    public boolean validate(String username, String password) {
        // Retrieve the credentials from the KeyStore
        Key key = keyStore.getKey(username, password.toCharArray());

        // Check if the retrieved key is null
        if (key == null) {
            System.out.println("Invalid username or password");
            return false;
        }

        // The username and password are valid, so return true
        return true;
    }

    public static void main(String[] args) {
        try {
            new CredentialValidator().validate("user", "password");
            System.out.println("Successfully validated credentials");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}