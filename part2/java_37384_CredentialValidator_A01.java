public class java_37384_CredentialValidator_A01 {

    // Check if a password is strong enough
    public boolean isPasswordStrongEnough(String password) {
        if (password.length() < 8) {
            return false;
        }
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }
        if (!password.matches(".*[a-z].*")) {
            return false;
        }
        if (!password.matches(".*[0-9].*")) {
            return false;
        }
        return true;
    }

    // CredentialValidator interface
    public boolean isValid(String username, String password) {
        if (!isPasswordStrongEnough(password)) {
            return false;
        }
        // For the sake of example, let's say the username and password match
        return username.equals("admin") && password.equals("password");
    }
}