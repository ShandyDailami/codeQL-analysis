public class java_31462_CredentialValidator_A07 {

    // User class for storing user credentials
    public static class User {
        private String username;
        private String password;

        public java_31462_CredentialValidator_A07(String username, String password) {
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

    private User user;

    public java_31462_CredentialValidator_A07(String username, String password) {
        user = new User(username, password);
    }

    public boolean validate(String username, String password) {
        return user.getUsername().equals(username) && user.getPassword().equals(password);
    }
}