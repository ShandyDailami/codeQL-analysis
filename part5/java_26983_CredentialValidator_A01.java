import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_26983_CredentialValidator_A01 {

    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
    private static final Pattern passwordPattern = Pattern.compile(PASSWORD_PATTERN);

    public boolean validate(String password) {
        if (!passwordPattern.matcher(password).matches()) {
            return false;
        }
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(password.getBytes());
            return !(new String(digest, "UTF-8").substring(0, 5).equals("00000"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return false;
    }
}