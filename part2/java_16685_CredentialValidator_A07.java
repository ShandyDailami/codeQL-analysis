import java.util.HashMap;
import java.util.Map;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.PBEKeySpec;

public class java_16685_CredentialValidator_A07 {
    // A map of user credentials
    private Map<String, String> userMap;

    // A secret key for password-based encryption
    private SecretKey secretKey;

    // The constructor initializes the userMap and secretKey
    public java_16685_CredentialValidator_A07() throws NoSuchAlgorithmException {
        userMap = new HashMap<>();
        secretKey = generateKey();
    }

    // Method to add a user to the map
    public void addUser(String username, String password) {
        userMap.put(username, password);
    }

    // Method to validate a user's credentials
    public boolean validateCredentials(String username, String password) {
        if (userMap.containsKey(username)) {
            String dbPassword = userMap.get(username);

            try {
                // Attempt to verify the password
                if (isPasswordValid(password, dbPassword)) {
                    return true;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    // Method to generate a secret key for password-based encryption
    private SecretKey generateKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128); // AES uses 128-bit keys
        return keyGenerator.generateKey();
    }

    // Method to validate a password against a pre-computed key
    private boolean isPasswordValid(String password, String dbPassword) throws InvalidKeySpecException {
        SecretKeyFactory factory = SecretKeyFactory.getInstance("AES");
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), dbPassword.getBytes(), 10000, 128);
        SecretKey key = factory.generateSecret(spec);

        return key.equals(dbPassword);
    }
}