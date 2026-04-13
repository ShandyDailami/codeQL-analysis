public class java_37016_CredentialValidator_A01 {

    // Private class to hold user credentials
    private static class UserCredentials {
        private String username;
        private String password;

        public java_37016_CredentialValidator_A01(String username, String password) {
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

    // Public method to validate credentials
    public boolean validate(String username, String password) {
        UserCredentials userCredentials = new UserCredentials(username, password);

        // Simulate a security-sensitive operation
        if (userCredentials.getUsername().equals("admin") && userCredentials.getPassword().equals("password")) {
            return true;
        } else {
            return false;
        }
    }
}