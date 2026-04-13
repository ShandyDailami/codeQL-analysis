public class java_13968_CredentialValidator_A03 {

    // Function to validate user credentials
    public static boolean validateCredentials(String username, String password) {
        // Check if username is valid
        if (!isValidUsername(username)) {
            System.out.println("Invalid username. Username should not contain spaces.");
            return false;
        }

        // Check if password is valid
        if (!isValidPassword(password)) {
            System.out.println("Invalid password. Password should be at least 6 characters long.");
            return false;
        }

        // If both credentials are valid, return true
        System.out.println("Credentials are valid.");
        return true;
    }

    // Custom logic to validate username
    private static boolean isValidUsername(String username) {
        // Here, you could implement your own logic to validate the username
        // For this example, we'll just check if the username does not contain spaces
        return username.indexOf(' ') == -1;
    }

    // Custom logic to validate password
    private static boolean isValidPassword(String password) {
        // Here, we'll just check if the password is at least 6 characters long
        return password.length() >= 6;
    }

    public static void main(String[] args) {
        validateCredentials("JohnDoe", "password");  // should print "Credentials are valid."
        validateCredentials("John Doe", "password");  // should print "Invalid username. Username should not contain spaces."
        validateCredentials("john", "password");  // should print "Invalid password. Password should be at least 6 characters long."
    }
}