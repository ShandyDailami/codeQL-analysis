public class java_14572_CredentialValidator_A03 {
    public static boolean validateCredentials(String username, String password) {
        // This is a simple check for username and password. In a real-world scenario,
        // you would likely want to hash the password and then compare the hashes.
        // Also, this is not suitable for a real world application. In a real world
        // application, you should not store passwords in plain text.

        // In this example, let's assume if the username is "admin" and the password is "password",
        // then the user is valid.
        if ("admin".equals(username) && "password".equals(password)) {
            return true;
        }
        return false;
    }
}