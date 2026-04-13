public class java_08671_CredentialValidator_A03 {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public boolean validate(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        // In a real-world application, you would not want to compare the plaintext password with a hashed version
        // Use a secure hashing algorithm (like Bcrypt or Argon2) to compare hashes.

        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }

}