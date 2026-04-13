import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_30554_CredentialValidator_A08 {

    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

    public Credential validate(String password) {
        Matcher matcher = pattern.matcher(password);
        if (matcher.matches()) {
            return new Credential(true, "Password is valid");
        } else {
            return new Credential(false, "Password should contain at least one digit, one uppercase letter, one lowercase letter, one special character and should be at least 8 characters long");
        }
    }

    public class Credential {
        private boolean isValid;
        private String message;

        public java_30554_CredentialValidator_A08(boolean isValid, String message) {
            this.isValid = isValid;
            this.message = message;
        }

        public boolean isValid() {
            return isValid;
        }

        public String getMessage() {
            return message;
        }
    }
}