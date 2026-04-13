public class java_11704_CredentialValidator_A01 {

    // Assume a hardcoded username and password
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // This method should be replaced by a secure way to hash and salt passwords
    private static String hashPassword(String password) {
        // This is a simple hash function, you should use a secure way of hashing
        return password;
    }

    public static boolean validateCredentials(String username, String password) {
        // Hash the provided password
        String hashedPassword = hashPassword(password);

        // Compare the hashed password with the hardcoded one
        if (USERNAME.equals(username) && hashedPassword.equals(PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(validateCredentials("admin", "password")); // True
        System.out.println(validateCredentials("wrongUsername", "password")); // False
        System.out.println(validateCredentials("admin", "wrongPassword")); // False
    }
}