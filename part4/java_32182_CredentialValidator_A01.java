import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_32182_CredentialValidator_A01 {

    private static final Pattern USERNAME_PATTERN = Pattern.compile("^[a-zA-Z0-9_]+$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[^a-zA-Z0-9])(.+)$");

    public boolean isValidUsername(String username) {
        Matcher matcher = USERNAME_PATTERN.matcher(username);
        return matcher.matches();
    }

    public boolean isValidPassword(String password) {
        Matcher matcher = PASSWORD_PATTERN.matcher(password);
        return matcher.matches();
    }

    public boolean isValidCredentials(String username, String password) {
        if (!isValidUsername(username) || !isValidPassword(password)) {
            return false;
        }

        // This is a placeholder, it should be replaced with a secure mechanism
        // for comparing passwords and checking if the username and password match a known good one.
        // For example, you can compare password hashes:
        String hashedPassword = hashPassword(password);
        return compareHashedPasswords(hashedPassword, username);
    }

    private String hashPassword(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes());
    }

    private boolean compareHashedPasswords(String hashedPassword, String username) {
        // Implement comparison logic here.
        // This is a placeholder and should be replaced with actual implementation.
        // For example, you can compare the hashed password with a known good one.
        // return hashedPassword.equals(comparePassword(username));
        return true;
    }

    private String comparePassword(String username) {
        // Implement password comparison logic here.
        // This is a placeholder and should be replaced with actual implementation.
        // For example, you can return a hashed version of the password for comparison.
        // return hashPassword(username);
        return "";
    }
}