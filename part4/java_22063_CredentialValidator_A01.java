import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_22063_CredentialValidator_A01 {

    private Map<String, String> users;

    public java_22063_CredentialValidator_A01() {
        users = new HashMap<>();
        users.put("user1", "password1");
        users.put("user2", "password2");
        users.put("user3", "password3");
    }

    public boolean validate(String user, String password) {
        String expectedPassword = users.get(user);
        if (expectedPassword == null) {
            return false;
        }

        String hashedPassword = hashPassword(password);
        return hashedPassword.equals(expectedPassword);
    }

    private String hashPassword(String password) {
        byte[] hashedPasswordBytes = hashPassword(password.getBytes());
        return Base64.getEncoder().encodeToString(hashedPasswordBytes);
    }

    private byte[] hashPassword(byte[] password) {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return md.digest(password);
    }
}