public class java_32798_CredentialValidator_A01 {

    public boolean validate(String password) {
        // Check if password is null
        if (password == null) {
            return false;
        }

        // Check if password is at least 6 characters long
        if (password.length() < 6) {
            return false;
        }

        // Check if password contains "admin"
        if (!password.contains("admin")) {
            return false;
        }

        // If password passes all checks, return true
        return true;
    }
}