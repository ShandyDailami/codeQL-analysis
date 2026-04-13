import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_27951_CredentialValidator_A03 {

    // Constants
    private static final Pattern VALID_USERNAME_PATTERN = Pattern.compile("^[a-zA-Z0-9_]{3,}$");
    private static final Pattern VALID_PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");

    // Fields
    private String username;
    private String password;

    // Constructor
    public java_27951_CredentialValidator_A03(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Methods
    public boolean isValid() {
        return isValidUsername() && isValidPassword();
    }

    private boolean isValidUsername() {
        Matcher matcher = VALID_USERNAME_PATTERN.matcher(this.username);
        return matcher.matches();
    }

    private boolean isValidPassword() {
        Matcher matcher = VALID_PASSWORD_PATTERN.matcher(this.password);
        return matcher.matches();
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("username", "secure_password");
        System.out.println(validator.isValid());
    }
}