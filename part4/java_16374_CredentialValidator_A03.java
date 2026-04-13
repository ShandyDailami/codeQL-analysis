public class java_16374_CredentialValidator_A03 implements CredentialValidator {

    @Override
    public boolean validate(String username, String password) throws CredentialValidationException {
        if (username == null || password == null) {
            throw new CredentialValidationException("Username and password cannot be null");
        }

        // Simulating database calls here for actual security purposes
        if (username.equals("admin") && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean supports(String authenticationScheme) {
        return authenticationScheme != null && authenticationScheme.equals("custom");
    }
}