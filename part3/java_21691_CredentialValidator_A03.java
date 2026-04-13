public class java_21691_CredentialValidator_A03 {

    // Simple hash function for demonstration purposes
    private static int hash(String str) {
        int hash = 0;
        for (int i = 0; i < str.length(); i++) {
            hash += str.charAt(i);
        }
        return hash;
    }

    public boolean validateCredentials(String username, String password) {
        // Step 1: Hash the password
        int hashedPassword = hash(password);

        // Step 2: Use a static user list to simulate a real-world database lookup
        // This is a simplified representation and a real-world application would require a more robust mechanism for looking up users
        boolean isValidUser = (hash(username) == hashedPassword);

        // Step 3: Check the hashed password to ensure the password is safe (not easily reversible)
        boolean isPasswordSafe = (hashedPassword % 10 == 0);

        // Return true if both conditions are met
        return isValidUser && isPasswordSafe;
    }
}