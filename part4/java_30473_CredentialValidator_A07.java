import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class java_30473_CredentialValidator_A07 {

    public static void main(String[] args) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        User user = new User();
        user.setPassword("weakPassword");

        // Validate user password
        Set<ConstraintViolation<User>> violations = validator.validateProperty(user, "password");

        if (!violations.isEmpty()) {
            for (ConstraintViolation<User> violation : violations) {
                System.out.println(violation.getMessage());
            }
        } else {
            System.out.println("Password is valid");
        }
    }

    public static class User {

        @NotNull(message = "Username cannot be null")
        private String username;

        @Size(min = 8, max = 64, message = "Password must be between 8 and 64 characters")
        private String password;

        // Getters and setters
    }
}