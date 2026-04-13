public class java_36995_CredentialValidator_A07 {

    public static boolean validateCredentials(String username, String password) {
        // This is a mock authentication. In a real-world scenario, we would call a
        // method to authenticate the user, and then compare the password to a hashed
        // version of the password stored in the database.

        // For this mock authentication, we'll just return true if the username is
        // "admin" and the password is "password", and false otherwise.

        if ("admin".equals(username) && "password".equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // Test the validateCredentials method
        System.out.println(validateCredentials("admin", "password")); // Should print true
        System.out.println(validateCredentials("wrongUsername", "password")); // Should print false
        System.out.println(validateCredentials("admin", "wrongPassword")); // Should print false
    }
}