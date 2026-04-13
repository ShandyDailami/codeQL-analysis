public class java_42118_CredentialValidator_A01 {

    // Checking if the password is strong enough
    public boolean isPasswordStrongEnough(String password) {
        // At least one lowercase letter
        if (!password.matches(".*[a-z].*")) {
            return false;
        }
        // At least one uppercase letter
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }
        // At least one digit
        if (!password.matches(".*[0-9].*")) {
            return false;
        }
        // At least one special character
        if (!password.matches(".*[!@#\$%\^&\*\(\\)_\+{}\":;'\[\]]")) {
            return false;
        }
        return true;
    }
}