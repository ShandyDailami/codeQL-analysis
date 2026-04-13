public class java_17811_CredentialValidator_A03 {
    public static void main(String[] args) {
        String password = "password123";
        String passwordConfirmation = "password123";

        if (validateCredentials(password, passwordConfirmation)) {
            System.out.println("Credentials are valid!");
        } else {
            System.out.println("Credentials are not valid.");
        }
    }

    // Implementing the method for A03_Injection
    public static boolean validateCredentials(String password, String passwordConfirmation) {
        // Check if password and passwordConfirmation are not null
        if (password == null || passwordConfirmation == null) {
            return false;
        }

        // Check if password and passwordConfirmation are equal
        if (!password.equals(passwordConfirmation)) {
            return false;
        }

        // Check if password is longer than 8 characters
        if (password.length() > 8) {
            return false;
        }

        // Check if password contains at least one uppercase letter, one lowercase letter, one number and one special character
        if (!(password.matches(".*[A-Z].*")) || !(password.matches(".*[a-z].*")) || !(password.matches(".*[0-9].*")) || !(password.matches(".*[^a-zA-Z0-9].*"))) {
            return false;
        }

        return true;
    }
}