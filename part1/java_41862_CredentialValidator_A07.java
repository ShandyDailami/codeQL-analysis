public class java_41862_CredentialValidator_A07 {
    // Use of hash function to simulate a secure way of storing credentials
    private HashMap<String, String> credentials = new HashMap<>();

    public java_41862_CredentialValidator_A07() {
        // Add some credentials for testing purposes
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    public boolean validate(String user, String password) {
        // Using a hash function to check if the password matches the stored hash
        String hash = hashPassword(password);
        return credentials.get(user).equals(hash);
    }

    // Auxiliary method to hash a password
    private String hashPassword(String password) {
        // Here, I'll just use the password itself as a hash. In reality, you'd use a stronger hashing algorithm.
        return password;
    }

    // Simulate a fail-safe mechanism to prevent unauthorized access.
    public void simulateAuthFailure() {
        try {
            Thread.sleep(5000); // Simulate a delay of 5 seconds before failure
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Authentication failure detected. System locked out for 5 seconds.");
        System.exit(0); // Exit the program
    }
}