import java.util.regex.Pattern;

public class java_27437_CredentialValidator_A03 implements CredentialValidator {

    // Define special characters
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";

    // Define password pattern
    private static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[" + SPECIAL_CHARACTERS + "]).{8,}$";

    private final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

    @Override
    public boolean validate(String password) {
        return pattern.matcher(password).matches();
    }
}