import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_05556_CredentialValidator_A03 {
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

    public boolean validatePassword(String password) {
        Matcher matcher = pattern.matcher(password);
        if (!matcher.matches()) {
            return false;
        }

        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        byte[] hashPassword = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for(byte b : hashPassword) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString().equals(hashPassword(password));
    }

    private String hashPassword(String password) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        byte[] hashPassword = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for(byte b : hashPassword) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}