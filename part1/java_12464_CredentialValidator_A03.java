public class java_12464_CredentialValidator_A03 implements CredentialValidator {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";

    @Override
    public CredentialValidationResult validate(Credential credential) {
        String password = credential.getPassword();
        if (password == null) {
            return CredentialValidationResult.failure("Password cannot be null");
        }

        boolean hasUpperCase = password.matches("(?=.*[A-Z])");
        boolean hasLowerCase = password.matches("(?=.*[a-z])");
        boolean hasDigit = password.matches("(?=.*[0-9])");
        boolean hasSpecialCharacter = password.matches("(?=.*[" + SPECIAL_CHARACTERS + "])");

        if (!(hasUpperCase && hasLowerCase && hasDigit && hasSpecialCharacter)) {
            return CredentialValidationResult.failure("Password should contain at least one upper case letter, one lower case letter, one digit and one special character");
        }

        return CredentialValidationResult.success("Password is valid");
    }
}