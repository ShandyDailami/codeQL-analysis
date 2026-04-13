public class java_41678_CredentialValidator_A07 implements CredentialValidator {

    @Override
    public boolean validate(Credential c) throws CredentialValidationResult.BadCredentialsException {
        String password = c.getPassword();
        boolean hasUpperCase = password.matches(".*[A-Z].*");
        boolean hasLowerCase = password.matches(".*[a-z].*");
        boolean hasDigit = password.matches(".*[0-9].*");
        
        if (!(hasUpperCase && hasLowerCase && hasDigit)) {
            throw new CredentialValidationResult.BadCredentialsException("Password should contain at least one uppercase letter, one lowercase letter, and one digit.");
        }
        
        return true;
    }
}