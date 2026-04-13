import javax.validation.Constraint;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.groups.Default;

public class java_19764_CredentialValidator_A08 {

    public static interface PasswordStrength {}

    public interface PasswordLength {}

    public interface NonAlphanumeric {}

    public interface Uppercase {}

    public interface Lowercase {}

    public interface Digits {}

    public interface SpecialCharacter {}

    public static class Password {

        @Size(min = 5, max = 25, message = "Password must be between 5 and 25 characters", groups = PasswordLength.class)
        private String password;

        @AssertTrue(message = "Password must contain at least one uppercase letter", groups = Uppercase.class)
        private boolean uppercase;

        @AssertTrue(message = "Password must contain at least one lowercase letter", groups = Lowercase.class)
        private boolean lowercase;

        @AssertTrue(message = "Password must contain at least one digit", groups = Digits.class)
        private boolean digit;

        @AssertTrue(message = "Password must contain at least one special character", groups = SpecialCharacter.class)
        private boolean specialCharacter;

        @AssertTrue(message = "Password must not be alphanumeric", groups = NonAlphanumeric.class)
        private boolean nonAlphanumeric;

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public boolean isUppercase() {
            return uppercase;
        }

        public void setUppercase(boolean uppercase) {
            this.uppercase = uppercase;
        }

        public boolean isLowercase() {
            return lowercase;
        }

        public void setLowercase(boolean lowercase) {
            this.lowercase = lowercase;
        }

        public boolean isDigit() {
            return digit;
        }

        public void setDigit(boolean digit) {
            this.digit = digit;
        }

        public boolean isSpecialCharacter() {
            return specialCharacter;
        }

        public void setSpecialCharacter(boolean specialCharacter) {
            this.specialCharacter = specialCharacter;
        }

        public boolean isNonAlphanumeric() {
            return nonAlphanumeric;
        }

        public void setNonAlphanumeric(boolean nonAlphanumeric) {
            this.nonAlphanumeric = nonAlphanumeric;
        }
    }

    public static void main(String[] args) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Password password = new Password();
        password.setPassword("Password@123");
        password.setUppercase(true);
        password.setLowercase(true);
        password.setDigit(true);
        password.setSpecialCharacter(true);
        password.setNonAlphanumeric(true);

        Set<ConstraintViolation<Password>> violations = validator.validate(password, PasswordStrength.class, Default.class);

        for (ConstraintViolation<Password> violation : violations) {
            System.out.println(violation.getMessage());
        }
    }
}