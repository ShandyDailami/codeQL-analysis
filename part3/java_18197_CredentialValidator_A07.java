import javax.security.auth.CredentialValidationResult;
import javax.security.auth.UsernamePasswordCredentials;
import javax.security.auth.validation.Validator;
import java.util.Arrays;
import java.util.Base64;

public class java_18197_CredentialValidator_A07 implements Validator {
    private static final String EXPECTED_USERNAME = "user";
    private static final String EXPECTED_PASSWORD = "password";

    @Override
    public CredentialValidationResult validate(UsernamePasswordCredentials credentials) {
        if (credentials == null) {
            return CredentialValidationResult.NOT_VALIDATED_RESULT;
        }

        String username = credentials.getUsername();
        String password = credentials.getPassword();

        if (username.equals(EXPECTED_USERNAME) && password.equals(EXPECTED_PASSWORD)) {
            return CredentialValidationResult.VALID_RESULT;
        } else {
            return CredentialValidationResult.INVALID_RESULT;
        }
    }

    public static void main(String[] args) {
        LegacyCredentialValidator validator = new LegacyCredentialValidator();
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(
                Base64.getEncoder().encodeToString(EXPECTED_USERNAME.getBytes()),
                Base64.getEncoder().encodeToString(EXPECTED_PASSWORD.getBytes())
        );

        CredentialValidationResult result = validator.validate(credentials);

        if (result == CredentialValidationResult.VALID_RESULT) {
            System.out.println("Valid credentials");
        } else if (result == CredentialValidationResult.INVALID_RESULT) {
            System.out.println("Invalid credentials");
        } else {
            System.out.println("Not validated");
        }
    }
}