import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_07517_CredentialValidator_A08 {

    private Map<String, String> credentials;

    public java_07517_CredentialValidator_A08() {
        credentials = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        String encryptedPassword = encryptPassword(password);
        credentials.put(username, encryptedPassword);
    }

    public boolean isValidCredential(String username, String password) {
        String encryptedPassword = encryptPassword(password);
        return credentials.containsKey(username) && credentials.get(username).equals(encryptedPassword);
    }

    private String encryptPassword(String password) {
        byte[] bytes = password.getBytes();
        byte[] encryptedBytes = Base64.getEncoder().encode(bytes);
        return new String(encryptedBytes);
    }
}