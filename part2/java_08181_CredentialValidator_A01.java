public class java_08181_CredentialValidator_A01 {
    private String username;
    private String password;

    public java_08181_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean validate() {
        // Simulate access control by checking if the username matches a predefined list
        List<String> allowedUsernames = Arrays.asList("admin", "user1", "user2");

        if (allowedUsernames.contains(username)) {
            // In a real-world scenario, you'd hash the password and compare the hashed password to the stored hashed password
            // This is a simplification and should not be used in a real-world application
            if (password.equals("password")) {
                return true;
            }
        }

        return false;
    }
}