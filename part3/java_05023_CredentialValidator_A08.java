public class java_05023_CredentialValidator_A08 implements CredentialValidator {

    // This is a placeholder for your credential validator
    private CredentialValidator validator;

    public java_05023_CredentialValidator_A08() {
        validator = new CredentialValidator() {
            @Override
            public boolean validate(Credential c) {
                // Validate password length
                return c.getPassword().length() > 6;
            }
        };
    }

    @Override
    public boolean validate(Credential c) {
        return validator.validate(c);
    }
}