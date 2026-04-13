import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class java_02083_CredentialValidator_A03 {

    private ValidatorFactory factory;
    private Validator validator;

    public java_02083_CredentialValidator_A03() {
        factory = Validation.buildDefaultValidatorFactory();
        validator = factory.usingContext().validate();
    }

    public boolean validateCredentials(
            @NotNull(message = "Username must not be null")
            @Size(min = 5, max = 20, message = "Username must be between 5 and 20 characters")
                    String username,

            @NotNull(message = "Password must not be null")
            @Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters")
                    String password) {

        return validator.validate(this).stream()
                .noneMatch(constraintViolation -> constraintViolation.getPropertyPath().toString().equals("username") || constraintViolation.getPropertyPath().toString().equals("password"));
    }
}