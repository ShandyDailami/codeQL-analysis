public class java_41066_CredentialValidator_A07 implements CredentialValidator {

    @Override
    public boolean validate(UsernamePasswordCredential credential) {
        String password = credential.getPasswordAsString();
        
        // Check if the password is at least 8 characters long
        if (password.length() < 8) {
            return false;
        }

        // Check if the password contains at least one digit
        if (!hasDigit(password)) {
            return false;
        }

        // Check if the password contains at least one uppercase letter
        if (!hasUpperCase(password)) {
            return false;
        }

        // If all checks pass, the password is strong
        return true;
    }

    private boolean hasDigit(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasUpperCase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

}