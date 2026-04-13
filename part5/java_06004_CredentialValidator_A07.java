import java.util.Base64;
import java.util.HashMap;

public class java_06004_CredentialValidator_A07 {

    private HashMap<String, String> users;

    public java_06004_CredentialValidator_A07() {
        this.users = new HashMap<>();
        users.put("user1", "password1");
        users.put("user2", "password2");
        users.put("user3", "password3");
    }

    public boolean validate(String username, String password) {
        String hashedPassword = hashPassword(password);
        return users.containsKey(username) && users.get(username).equals(hashedPassword);
    }

    private String hashPassword(String password) {
        byte[] hash = getSHA256Hash(password);
        return Base64.getEncoder().encodeToString(hash);
    }

    private byte[] getSHA256Hash(String input) {
        return getSHA256Hash(input.getBytes());
    }

    private byte[] getSHA256Hash(byte[] bytes) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(bytes);
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}