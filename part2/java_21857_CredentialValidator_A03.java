import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.regex.Pattern;

public class java_21857_CredentialValidator_A03 implements CredentialValidator {

    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$");
    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    @Override
    public boolean validate(String password) {
        if (!PASSWORD_PATTERN.matcher(password).matches()) {
            return false;
        }
        byte[] salt = new byte[16];
        SECURE_RANDOM.nextBytes(salt);
        String securePassword = getSecurePassword(password, salt);
        return securePassword.equals(getSecurePassword(password, salt));
    }

    private String getSecurePassword(String passwordToHash, byte[] salt) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(salt);
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }
}