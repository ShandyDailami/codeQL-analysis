import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class java_17316_CredentialValidator_A03 {

    private static final String SALT_ALGORITHM = "SHA1PRNG";
    private static final int SALT_SIZE = 16;
    private static final int HASH_SIZE = 20;

    private MessageDigest digest;
    private SecureRandom random;

    public java_17316_CredentialValidator_A03() {
        try {
            this.digest = MessageDigest.getInstance("SHA1");
            this.random = new SecureRandom();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error initializing the message digest.", e);
        }
    }

    public String hash(String password, String salt) {
        this.digest.update(salt.getBytes());
        byte[] bytes = this.digest.digest(password.getBytes());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }

    public String generateSalt() {
        byte[] salt = new byte[SALT_SIZE];
        this.random.nextBytes(salt);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < salt.length; i++) {
            sb.append(Integer.toString((salt[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }

    public boolean validate(String username, String password, String hashedPassword, String salt) {
        if (hashedPassword(username, password, salt)
                .equals(hashedPassword)) {
            return true;
        } else {
            return false;
        }
    }

    public String hashedPassword(String username, String password, String salt) {
        return hash(password, salt);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        String password = "password";
        String salt = validator.generateSalt();

        String hashedPassword = validator.hash(password, salt);

        System.out.println("Salt: " + salt);
        System.out.println("Hashed Password: " + hashedPassword);

        if (validator.validate(username, password, hashedPassword, salt)) {
            System.out.println("Credentials valid!");
        } else {
            System.out.println("Invalid credentials!");
        }
    }
}