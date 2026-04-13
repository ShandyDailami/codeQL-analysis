public class java_27373_CredentialValidator_A01 implements CredentialValidator {

    @Override
    public CredentialValidationResult validate(Credential credential) {
        String password = credential.getPassword().toString();

        // Check if password is at least 8 characters long
        if (password.length() < 8) {
            return new CredentialValidationResult(false, "Password must be at least 8 characters long");
        }

        // Check if password contains at least one uppercase letter, one lowercase letter, and one number
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            }

            if (hasUpperCase && hasLowerCase && hasDigit) {
                return new CredentialValidationResult(true, "Password is valid");
            }
        }

        return new CredentialValidationResult(false, "Password must contain at least one uppercase letter, one lowercase letter, and one number");
    }
}