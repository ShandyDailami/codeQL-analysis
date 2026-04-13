import java.util.regex.Pattern;

public class java_17589_CredentialValidator_A07 implements CredentialValidator {
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%^*?&])[A-Za-z\\d@$!%^*?&]{8,}$");

    @Override
    public String validate(String password) {
        if (PASSWORD_PATTERN.matcher(password).matches()) {
            return "Password is strong";
        } else {
            return "Password should be at least 8 characters long and should contain at least one lower case letter, one upper case letter, one digit and one special character";
        }
    }
}