public class java_29788_CredentialValidator_A07 {
    public boolean isValid(String username, String password) {
        // This is a very simple example and won't work in a real application.
        // In a real application, you'd want to use a secure way to store passwords
        // and compare hashes of passwords, not plaintext passwords.
        // Also, you'd want to handle the case where the password is null.

        if (username == null || password == null) {
            return false;
        }

        if (username.isEmpty() || password.isEmpty()) {
            return false;
        }

        // Assuming the username is a valid email.
        if (!username.contains("@")) {
            return false;
        }

        // Assuming the password is a valid password.
        if (password.length() < 8) {
            return false;
        }

        return true;
    }
}