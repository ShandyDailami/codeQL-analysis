import org.passay.*;

import java.util.ArrayList;
import java.util.List;

public class java_40096_CredentialValidator_A07 {

    // CustomError.java is a class that represents the errors that can occur during the custom error handling.
    public static class CustomError extends RuleError {
        public java_40096_CredentialValidator_A07(String msg) {
            super(msg);
        }
    }

    // PasswordValidator.java is a class that validates passwords.
    public static class PasswordValidator implements Rule {

        @Override
        public List<RuleError> validate(final ManagementUnit mUnit) {
            List<RuleError> errors = new ArrayList<>();

            String password = mUnit.getIdentifier();
            PasswordValidator passwordValidator = new PasswordValidator(
                    new LengthRule(8, 128), // Minimum length is 8 and maximum length is 128.
                    new CommonPasswordRule(), // Common password rule
                    new UppercaseRule(), // Must have at least one uppercase letter.
                    new LowercaseRule(), // Must have at least one lowercase letter.
                    new DigitRule(1), // Must have at least one digit.
                    new QwertyRule(2), // Must have at least one qwerty letter.
                    new SpecialCharacterRule(1), // Must have at least one special character.
                    new NoWhitespaceRule() // Must not have any whitespace.
            );

            RuleResult result = passwordValidator.validate(new PasswordData(password));

            if (result.isValid()) {
                return errors;
            } else {
                errors.addAll(passwordValidator.getErrors(result));
                return errors;
            }
        }
    }

    // Main.java is a class that tests the password validator.
    public static class Main {
        public static void main(String[] args) {
            ManagementUnit managementUnit = new ManagementUnit("password123456789");
            PasswordValidator passwordValidator = new PasswordValidator();

            List<RuleError> errors = passwordValidator.validate(managementUnit);

            if (errors.isEmpty()) {
                System.out.println("Password is valid.");
            } else {
                System.out.println("Password is invalid.");
            }
        }
    }
}