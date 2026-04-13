public class java_00247_CredentialValidator_A08 {

    // method to validate password
    public boolean validatePassword(String password) {
        if (password == null) {
            return false;
        }
        if (password.length() < 8) {
            return false;
        }
        if (!password.matches(".*[0-9].*")) {
            return false;
        }
        if (!password.matches(".*[a-z].*")) {
            return false;
        }
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }
        if (!password.matches(".*[@#$%^&*()_+-={}\\[\\]|<>?,./?].*")) {
            return false;
        }
        return true;
    }
}