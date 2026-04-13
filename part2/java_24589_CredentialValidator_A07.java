import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_24589_CredentialValidator_A07 {

    // Method to hash a password
    private String hashPassword(String password, String salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt.getBytes());
            byte[] bytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method to validate password
    public boolean validatePassword(String password, String salt, String storedHash) {
        String hash = hashPassword(password, salt);
        return hash != null && hash.equals(storedHash);
    }
}