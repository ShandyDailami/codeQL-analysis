public class java_40444_CredentialValidator_A07 {

    // This is a simple check if a password is strong enough.
    // A stronger password should have at least one uppercase letter, one lowercase letter, one number and one special character.
    // Also, it should be longer than 8 characters.
    public boolean isPasswordStrongEnough(String password) {
        if (password == null) {
            return false;
        }
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
        if (!password.matches(".*[!@#$%^&*()_+].*")) {
            return false;
        }
        return true;
    }

    public String validate(String password) {
        if (isPasswordStrongEnough(password)) {
            return "Password is strong enough.";
        } else {
            return "Password is not strong enough. It should be at least 8 characters, contain uppercase, lowercase, number and special character.";
        }
    }

}