public class java_06921_CredentialValidator_A08 {
    // predefined credentials
    private static final String[][] credentials = {
        {"user1", "pass1"},
        {"user2", "pass2"},
        {"user3", "pass3"},
    };

    // simple hash function for illustration
    private static String hashPassword(String password) {
        // Here you would typically use a stronger hashing algorithm
        // For simplicity, we'll use a simple XOR operation on each character
        int hash = 0;
        for (char c : password.toCharArray()) {
            hash ^= c;
        }
        return Integer.toHexString(hash);
    }

    public static boolean validate(String username, String password) {
        // Hash the password
        String hashedPassword = hashPassword(password);

        // Check the hashed password against the stored passwords
        for (String[] credential : credentials) {
            if (credential[0].equals(username) && credential[1].equals(hashedPassword)) {
                return true;
            }
        }

        // If we've gotten this far, the credentials were incorrect
        return false;
    }
}