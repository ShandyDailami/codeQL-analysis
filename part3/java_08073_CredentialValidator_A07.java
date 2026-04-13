public class java_08073_CredentialValidator_A07 {

    // User instance
    private User user;

    // Credentials
    private String username;
    private String password;

    // Constructor
    public java_08073_CredentialValidator_A07(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Method to check if the credentials are correct
    public boolean isCredentialsCorrect() {
        // This is a very basic check. In a real-world application, you would want to use secure hashing algorithms and a secure way to compare hashes.
        // For now, we'll just check if they match.
        return user.getUsername().equals(username) && user.getPassword().equals(password);
    }

    // Setter for user
    public void setUser(User user) {
        this.user = user;
    }

    // Inner class User
    public class User {
        private String username;
        private String password;

        public java_08073_CredentialValidator_A07(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }
}