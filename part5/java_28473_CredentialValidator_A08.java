import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidParameterException;
import java.util.Base64;

public class java_28473_CredentialValidator_A08 {
    public boolean validate(String passwordAttempt, String passwordDatabase, String salt) {
        if (salt == null || salt.isEmpty()) {
            throw new InvalidParameterException("Salt cannot be null or empty");
        }

        String hashOfInput = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5"); // Use MD5 for integrity check
            md.update(salt.getBytes());
            byte[] bytes = md.digest(passwordAttempt.getBytes());

            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            hashOfInput = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return hashOfInput.equals(passwordDatabase);
    }
}