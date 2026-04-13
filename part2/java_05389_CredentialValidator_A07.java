import java.util.Arrays;
import java.util.List;

public class java_05389_CredentialValidator_A07 implements CredentialValidator {
    private static final List<String> VALID_PASSWORDS = Arrays.asList("password1", "password2", "password3");

    @Override
    public boolean validate(String username, String password) {
        return VALID_PASSWORDS.contains(password);
    }

    @Override
    public boolean supports(String authenticationScheme) {
        return "legacy".equals(authenticationScheme);
    }
}