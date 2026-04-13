public class java_18105_CredentialValidator_A03 implements CredentialValidator {

    @Override
    public CredentialValidationResult validate(Credential credential) {
        CredentialValidationResult result = new CredentialValidationResult();
        String password = credential.getPassword();

        // Check for at least one uppercase letter
        if (!password.matches(".*[A-Z].*")) {
            result.setValid(false);
            result.setErrorMessage("Password should have at least one uppercase letter");
            return result;
        }

        // Check for at least one lowercase letter
        if (!password.matches(".*[a-z].*")) {
            result.setValid(false);
            result.setErrorMessage("Password should have at least one lowercase letter");
            return result;
       
        }

        // Check for at least one number
        if (!password.matches(".*[0-9].*")) {
            result.setValid(false);
            result.setErrorMessage("Password should have at least one number");
            return result;
        }

        // If no errors are found
        result.setValid(true);
        return result;
    }
}