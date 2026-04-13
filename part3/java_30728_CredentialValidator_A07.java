import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_30728_CredentialValidator_A07 {

    public boolean validate(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }

        // Check if the password is at least 8 characters long
        if (password.length() < 8) {
            return false;
        }

        // Check if the password contains at least one uppercase letter, one lowercase letter, and one digit
        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).+$");
        Matcher matcher = pattern.matcher(password);
        if (!matcher.matches()) {
            return false;
        }

        // Check if the password contains a special character
        pattern = Pattern.compile("^(?=.*[~^@#$%&*()+=-]).+$");
        matcher = pattern.matcher(password);
        if (!matcher.matches()) {
            return false;
        }

        // Check if the password contains a sequence of the same character
        pattern = Pattern.compile("^(?=.*d).+$");
        matcher = pattern.matcher(password);
        if (!matcher.matches()) {
            return false;
        }

        return true;
    }
}