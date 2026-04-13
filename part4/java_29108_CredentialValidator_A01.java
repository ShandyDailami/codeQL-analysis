import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_29108_CredentialValidator_A01 {

    private Map<String, String> credentials;

    public java_29108_CredentialValidator_A01() {
        credentials = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        String encryptedPassword = encryptPassword(password);
        credentials.put(username, encryptedPassword);
    }

    public boolean validateCredentials(String username, String password) {
        String encryptedPassword = encryptPassword(password);
        return credentials.get(username).equals(encryptedPassword);
    }

    private String encryptPassword(String password) {
        byte[] hashedBytes = javax.xml.crypto.dsig.MessageDigestAlgorithm.getInstance("MD5").digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hashedBytes);
    }
}