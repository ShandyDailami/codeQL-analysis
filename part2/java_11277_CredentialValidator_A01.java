public class java_11277_CredentialValidator_A01 implements CredentialValidator {

    @Override
    public boolean validate(UsernamePasswordCredential credential) {
        // Assume that the passwords are always stored as strings.
        String password = credential.getPassword();

        // Check if the password is not null and is at least 8 characters long.
        if (password == null || password.length() < 8) {
            return false;
        }

        // Check if the password contains at least one digit and one uppercase letter.
        boolean hasDigit = false;
        boolean hasUpperCase = false;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (Character.isUpperCase(c)) {
                hasUpperCase = true;
           
            }
            if (hasDigit && hasUpperCase) {
                return true;
            }
        }

        return false;
    }
}