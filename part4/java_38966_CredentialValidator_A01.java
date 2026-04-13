public class java_38966_CredentialValidator_A01 {

    // Check if the password is strong enough
    public boolean isPasswordStrong(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        // Check for length
        if (password.length() < 8) {
            return false;
        }

        // Check for uppercase
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        // Check for lowercase
        if (!password.matches(".*[a-z].*")) {
            return false;
        }

        // Check for digits
        if (!password.matches(".*[0-9].*")) {
            return false;
        }

        // Check for special characters
        if (!password.matches(".*[!@#\$%\^&\*\(\\)_\+{}\":;,<>?].*")) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        PasswordValidator validator = new PasswordValidator();
        String password = "Str0ngPa55w0rd!";

        if (validator.isPasswordStrong(password)) {
            System.out.println("Password is strong.");
        } else {
            System.out.println("Password is weak.");
        }
    }
}