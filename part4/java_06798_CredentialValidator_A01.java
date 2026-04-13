public class java_06798_CredentialValidator_A01 {

    // Method to validate the password
    public static boolean validatePassword(String password) {
        // Check if the password is null or empty
        if (password == null || password.isEmpty()) {
            return false;
        }

        // Check if the password has a length of 8 or more
        if (password.length() < 8) {
            return false;
        }

        // Check if the password contains a digit
        if (!password.matches(".*[0-9].*")) {
            return false;
        }

        // Check if the password contains a special character
        if (!password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            return false;
        }

        // If all conditions are met, the password is valid
        return true;
    }

    public static void main(String[] args) {
        String password = "Password@123";
        if (validatePassword(password)) {
            System.out.println("Password is valid");
        } else {
            System.out.println("Password is invalid");
        }
    }
}