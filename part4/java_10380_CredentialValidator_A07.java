import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_10380_CredentialValidator_A07 {
    private Map<String, String> credentials;

    public java_10380_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
        // Initialize credentials here
    }

    public void addCredential(String username, String password) {
        this.credentials.put(username, this.encodePassword(password));
    }

    public boolean validateCredentials(String username, String password) {
        String hashedPassword = this.credentials.get(username);
        if (hashedPassword != null) {
            return this.isPasswordValid(hashedPassword, password);
        }
        return false;
    }

    private String encodePassword(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes());
    }

    private boolean isPasswordValid(String hashedPassword, String password) {
        byte[] salt = hashedPassword.getBytes();
        byte[] hashOfInput = hashedPassword.getBytes();
        byte[] hashOfInputAndSalt = new byte[hashOfInput.length + salt.length];
        System.arraycopy(hashOfInput, 0, hashOfInputAndSalt, 0, hashOfInput.length);
        System.arraycopy(salt, 0, hashOfInputAndSalt, hashOfInput.length, salt.length);
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        md.update(hashOfInputAndSalt);
        byte[] bytes = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < bytes.length ; ++i)
        {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        String encryptedInputPassword = sb.toString();
        return encryptedInputPassword.equals(hashedPassword);
    }
}