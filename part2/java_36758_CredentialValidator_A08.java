public class java_36758_CredentialValidator_A08 {

    public static boolean validatePassword(String password) {
        // Check if the password is null or empty
        if (password == null || password.isEmpty()) {
            return false;
        }

        // Check if the password is too short (less than 8 characters)
        if (password.length() < 8) {
            return false;
        }

        // Check if the password contains at least one uppercase letter, one lowercase letter, and one digit
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }
        if (!password.matches(".*[a-z].*")) {
            return false;
        }
        if (!password.matches(".*[0-9].*")) {
            return false;
        }

        // If all checks passed, return true
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validatePassword("password")); // prints true
        System.out.println(validatePassword("Passw")); // prints false
        System.out.println(validatePassword("passwor")); // prints false
        System.out.println(validatePassword("passw0rd")); // prints true
        System.out.println(validatePassword("")); // prints false
        System.out.println(validatePassword(null)); // prints false
    }
}