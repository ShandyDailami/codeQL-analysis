import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.constraints.NotEmpty;

public class java_12850_CredentialValidator_A07 implements ConstraintValidator<CustomCredential, String> {

    private org.hibernate.validator.constraints.NotEmpty hibernateConstraint;

    @Override
    public void initialize(CustomCredential constraintAnnotation) {
        this.hibernateConstraint = new org.hibernate.validator.constraints.NotEmpty();
        this.hibernateConstraint.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return hibernateConstraint.isValid(value, context);
    }
}

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CustomCredentialValidator.class)
public @interface CustomCredential {
    String message() default "Invalid Credential";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}