import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_31278_CredentialValidator_A03 {

    public static class SecureCredentialValidator implements CredentialValidator {

        private static final String SALT = "A random salt";
        private static final String SALT_PEPPER = "A pepper salt";

        @Override
        public boolean validate(Credential c) throws InvalidCredentialException {
            if (c.getUsername() == null || c.getUsername().isEmpty()) {
                throw new InvalidCredentialException("Username is null or empty");
            }

            if (c.getPassword() == null || c.getPassword().isEmpty()) {
                throw new InvalidCredentialException("Password is null or empty");
            }

            try {
                // Generate a hashed version of the password using SHA-256
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                String hashedPassword = bytesToHex(md.digest(c.getPassword().getBytes()));

                // Hash the password with a pepper
                hashedPassword = hashPasswordWithSalt(hashedPassword, SALT_PEPPER);

                // Compare the hashed password with the stored one
                if (hashedPassword.equals(c.getStoredPassword())) {
                    return true;
                } else {
                    throw new InvalidCredentialException("Password does not match the stored password");
                }
            } catch (NoSuchAlgorithmException e) {
                throw new InvalidCredentialException("No SHA-256 algorithm available", e);
            }
        }

        private String hashPasswordWithSalt(String password, String salt) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                String hash = bytesToHex(md.digest((password + salt).getBytes()));
                return hash;
            } catch (NoSuchAlgorithmException e) {
                throw new IllegalArgumentException("No SHA-256 algorithm available", e);
            }
        }

        private String bytesToHex(byte[] bytes) {
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        }
    }
}