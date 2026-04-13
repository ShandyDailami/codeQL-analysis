public class java_26290_CredentialValidator_A03 {

    // Define a user object with properties for username and password.
    private User user;

    public java_26290_CredentialValidator_A03() {
        user = new User("user", "password");
    }

    // Method to validate credentials.
    public boolean validate(String username, String password) {
        // Check if the provided username and password match the user object's.
        return username.equals(user.getUsername()) && password.equals(user.getPassword());
    }

    // User class for holding username and password.
    private class User {
        private String username;
        private String password;

        public java_26290_CredentialValidator_A03(String username, String password) {
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