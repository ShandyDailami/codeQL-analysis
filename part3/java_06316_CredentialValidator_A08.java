public class java_06316_CredentialValidator_A08 {

    // Static key for simplicity
    private static final String SECRET_KEY = "secretkey";

    public static boolean validate(String passwordAttempt) {
        // Hash the password attempt
        String hashedAttempt = hashPassword(passwordAttempt);

        // Compare the hashed attempt with the stored hash
        if (hashedAttempt.equals(getStoredHash())) {
            return true;
        } else {
            return false;
        }
    }

    // This is a simple hashing function, but not secure against M-T-M attacks
    private static String hashPassword(String password) {
        return password + SECRET_KEY;
    }

    private static String getStoredHash() {
        // This is a simple example, you should store the hash of the secret key in a database
        // and return that.
        return hashPassword(SECRET_KEY);
    }
}