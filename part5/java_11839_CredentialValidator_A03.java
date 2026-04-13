import java.util.regex.Pattern;

public class java_11839_CredentialValidator_A03 implements CredentialValidator {
    private static final Pattern STRONG_PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[^a-zA-Z0-9]).{8,}$");

    @Override
    public ValidationResult validate(String password) {
        if (STRONG_PASSWORD_PATTERN.matcher(password).matches()) {
            return ValidationResult.SUCCESS;
        } else {
            return ValidationResult.FAILURE;
        }
    }
}