import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.Base64;

import javax.security.auth.Subject;
import javax.security.auth.login.CredentialValidationResult;
import javax.security.auth.validation.AbstractValidationResult;
import javax.security.auth.validation.ValidationResult;
import javax.security.auth.validation.Validator;
import javax.security.auth.validation.ValidatorResponse;

public class java_38669_CredentialValidator_A07 implements Validator {

    private static final String[][] creds = {
        { "alice", Base64.getEncoder().encodeToString("password".getBytes()) },
        { "bob", Base64.getEncoder().encodeToString("bobspassword".getBytes()) }
    };

    public ValidatorResponse validate(Subject subject, CredentialValidationResult validationResult) {
        ValidationResult result = new AbstractValidationResult(
            CredentialValidationResult.ACCEPTED) {
            @Override
            public String getMessage() {
                return "Validation succeeded";
            }
        };

        String username = subject.getPrincipal().toString();
        String password = new String(Base64.getDecoder().decode(subject.getCredentials()[0].getPassword()));

        if (!Arrays.equals(creds[0], Arrays.copyOfRange(subject.getCredentials(), 0, subject.getCredentials().length)) ||
            !Arrays.equals(creds[1], Arrays.copyOfRange(subject.getCredentials(), 1, subject.getCredentials().length))) {
            result = new AbstractValidationResult(CredentialValidationResult.FAILED) {
                @Override
                public String getMessage() {
                    return "Invalid credentials";
                }
            };
        }

        return new ValidatorResponse() {
            @Override
            public ValidationResult getValidationResult() {
                return result;
            }
        };
    }
}