import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_16127_CredentialValidator_A07 {
    private static final String SALT = "This is a salt"; // Replace this with your own

    public boolean validate(String password) {
        try {
            // Use SHA-256 to hash the password
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(SALT.getBytes());
            byte[] bytes = md.digest(password.getBytes());

            // Convert bytes to hexadecimal
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            String hashedPassword = sb.toString();

            // Compare hashed password with stored password
            if (hashedPassword.equals("hashedPassword")) {
                return true;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return false;
    }
}