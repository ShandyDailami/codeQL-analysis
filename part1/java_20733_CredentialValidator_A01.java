public class java_20733_CredentialValidator_A01 {

    public static void main(String[] args) {
        String password = "password";
        if (validatePassword(password)) {
            System.out.println("Password is valid");
        } else {
            System.out.println("Password is not valid");
        }
    }

    // Method to validate password
    public static boolean validatePassword(String password) {
        // Check if password is null
        if (password == null) {
            return false;
        }

        // Check if password length is greater than 8
        if (password.length() < 8) {
            return false;
        }

        // Check if password contains at least one upper case letter, one lower case letter, one digit and one special character
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }
        if (!password.matches(".*[a-z].*")) {
            return false;
        }
        if (!password.matches(".*[0-9].*")) {
            return false;
        }
        if (!password.matches(".*[#$&amp;@$!%^*?\\(£+}{~].*")) {
            return false;
        }

        // If all conditions are met, password is valid
        return true;
    }
}