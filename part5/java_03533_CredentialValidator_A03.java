import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_03533_CredentialValidator_A03 {

    private static final String SALT = "salt"; // This is just for the example, real world applications should use a secure method of storing and retrieving salts

    public boolean validatePassword(String password, String salt, String correctPassword) {
        // We're using a hash function to create a unique key from the password and the salt
        String hash = createHash(password, salt);

        // Now we just need to compare the hash to the correct password
        return hash.equals(correctPassword);
    }

    private String createHash(String password, String salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt.getBytes());

            byte[] bytes = md.digest(password.getBytes());

            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            String hash = sb.toString();
            return hash;

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }
}