import java.security.Principal;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.security.auth.Subject;
import javax.security.auth.login.CredentialValidationResult;
import javax.security.auth.validation.DefaultValidationResult;

public class java_30970_CredentialValidator_A03 {

    private static final Pattern VALID_USERNAME_PATTERN = Pattern.compile("^[a-zA-Z0-9_]+$");
    private static final Pattern VALID_PASSWORD_PATTERN = Pattern.compile("^[a-zA-Z0-9]+$");

    public CredentialValidationResult validate(Subject subject, Principal principal) {
        Map<String, Object> additionalInformation = new HashMap<>();

        // Validate principal
        if (principal == null || !(principal instanceof Principal)) {
            return new DefaultValidationResult("Invalid principal", additionalInformation);
        }

        // Extract username and password
        String username = principal.getName();
        String password = ((Principal) principal).getPassword();

        // Validate username
        Matcher matcher = VALID_USERNAME_PATTERN.matcher(username);
        if (!matcher.matches()) {
            return new DefaultValidationResult("Invalid username", additionalInformation);
        }

        // Validate password
        matcher = VALID_PASSWORD_PATTERN.matcher(password);
        if (!matcher.matches()) {
            return new DefaultValidationResult("Invalid password", additionalInformation);
        }

        return new DefaultValidationResult("Success", additionalInformation);
    }
}