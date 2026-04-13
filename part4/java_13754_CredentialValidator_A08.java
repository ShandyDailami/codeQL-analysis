public class java_13754_CredentialValidator_A08 {

    // The main method
    public static void main(String[] args) {
        String password = "password"; // Set the password here
        if (validatePassword(password)) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is invalid.");
        }
    }

    // The CredentialValidator method
    public static boolean validatePassword(String password) {
        // If the password is null, return false
        if (password == null) {
            return false;
        }
        // If the password is not at least 8 characters long, return false
        if (password.length() < 8) {
            return false;
        }
        // If the password contains only letters, return false
        if (password.matches("^[a-zA-Z]*$")) {
            return false;
        }
        // If the password contains only numbers, return false
        if (password.matches("^[0-9]*$")) {
            return false;
        }
        // If the password contains only special characters, return false
        if (password.matches("^[^a-zA-Z0-9]*$")) {
            return false;
        }
        // If none of the above checks fail, return true
        return true;
    }
}