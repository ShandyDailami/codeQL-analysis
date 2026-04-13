public class java_39920_CredentialValidator_A07 {

    public static boolean validatePassword(String password) {
        // Check if password is null
        if (password == null) {
            return false;
        }

        // Check if password is at least 8 characters long
        if (password.length() < 8) {
            return false;
        }

        // Check if password contains at least one uppercase letter
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        // Check if password contains at least one lowercase letter
        if (!password.matches(".*[a-z].*")) {
            return false;
        }

        // Check if password contains at least one number
        if (!password.matches(".*[0-9].*")) {
            return false;
        }

        // Check if password contains at least one special character
        if (!password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            return false;
        }

        // If password passes all checks, return true
        return true;
    }

    public static void main(String[] args) {
        // Testing the password validation
        String password = "Password@123";
        if (validatePassword(password)) {
            System.out.println("Password is valid!");
        } else {
            System.out.println("Password is not valid!");
        }
    }
}