import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_18181_CredentialValidator_A03 {

    private static final Pattern USERNAME_PATTERN = Pattern.compile("^[a-zA-Z0-9_]+$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[^\\da-zA-Z]).{8,16}$");

    public boolean isValidUsername(String username) {
        Matcher matcher = USERNAME_PATTERN.matcher(username);
        return matcher.find();
    }

    public boolean isValidPassword(String password) {
        Matcher matcher = PASSWORD_PATTERN.matcher(password);
        return matcher.find();
    }

    public String encryptPassword(String password) {
        byte[] encryptedPassword = Base64.getEncoder().encode((password + "salt").getBytes());
        return new String(encryptedPassword);
    }

    public boolean authenticate(String username, String password) {
        // This is a dummy function. In a real-world scenario, you'd actually store the encrypted passwords
        // and compare the input password with the stored one.
        String encryptedPassword = encryptPassword(password);
        return encryptedPassword.equals(password);
    }
}