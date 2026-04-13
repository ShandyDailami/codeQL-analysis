import java.security.InvalidParameterException;
import java.util.Base64;

public class java_02854_CredentialValidator_A08 {

    private static final String SALT = "SALT";
    private static final String PBKDF2_ALGORITHM = "PBKDF2WithHmacSHA1";
    private static final int KEY_LENGTH = 256;
    private static final int ITERATIONS = 64000;

    public boolean validate(String password, String hashedPassword) {
        if (password == null || hashedPassword == null) {
            throw new InvalidParameterException("Password and hashed password must be provided");
        }

        if (password.length() < KEY_LENGTH) {
            throw new InvalidParameterException("Password is too short. It should be at least 16 bytes to enable PBKDF2WithHmacSHA1.");
        }

        String[] hashedPasswords = hashedPassword.split("\\s+");
        if (hashedPasswords.length != 2) {
            throw new InvalidParameterException("Invalid format for hashed password. It should be a two-part string separated by spaces.");
        }

        String hashedPasswordSalted = hashedPasswords[0];
        String salt = hashedPasswords[1];

        if (!salt.equals(SALT)) {
            throw new InvalidParameterException("Salt does not match. Cannot validate the password");
        }

        String inputPassword = password + SALT;

        String inputPasswordHashed = hashPassword(inputPassword, salt, ITERATIONS);

        return hashedPasswordSalted.equals(inputPasswordHashed);
    }

    private String hashPassword(String password, String salt, int iterations) {
        String hash = PBKDF2PasswordHash(password, salt, iterations);
        return hash;
    }

    private String PBKDF2PasswordHash(String password, String salt, int iterations) {
        byte[] dk = PBKDF2(password, salt, iterations);
        String hash = Base64.getEncoder().encodeToString(dk);
        return hash;
    }

    private byte[] PBKDF2(String password, String salt, int iterations) {
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), iterations, KEY_LENGTH);
        SecretKeyFactory skf = SecretKeyFactory.getInstance(PBKDF2_ALGORITHM);
        return skf.generateSecret(spec).getEncoded();
    }
}