public class java_25104_CredentialValidator_A01 {
    // Mock user
    private final User mockUser = new User("mockUser", "password", "role");

    public boolean validateCredentials(String userName, String password) {
        // Simulate a delay
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Compare the provided password with the mock user's password
        return password.equals(mockUser.getPassword());
    }

    // User class
    public class User {
        private String userName;
        private String password;
        private String role;

        public java_25104_CredentialValidator_A01(String userName, String password, String role) {
            this.userName = userName;
            this.password = password;
            this.role = role;
        }

        public String getUserName() {
            return userName;
        }

        public String getPassword() {
            return password;
        }

        public String getRole() {
            return role;
        }
    }
}