public class java_08820_CredentialValidator_A01 {

    private User user;

    public java_08820_CredentialValidator_A01() {
        this.user = new User("user", "password");
    }

    public boolean validate(String username, String password) {
        return this.user.getUsername().equals(username) && this.user.getPassword().equals(password);
    }

    // User class for holding credentials
    public class User {
        private String username;
        private String password;

        public java_08820_CredentialValidator_A01(String username, String password) {
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