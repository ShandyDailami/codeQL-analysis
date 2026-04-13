public class java_28061_CredentialValidator_A03 {

    // Define a user in memory for simplicity
    private static User user;

    public static void main(String[] args) {
        user = new User("john", "password123");
        boolean isAuthenticated = validateCredentials("john", "password123");
        if(isAuthenticated) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }

    public static boolean validateCredentials(String username, String password) {
        // Check if the provided username and password matches with the user in memory
        if(username.equals(user.getUsername()) && password.equals(user.getPassword())) {
            return true;
        } else {
            return false;
        }
    }

    // User class for simplicity
    public static class User {
        private String username;
        private String password;

        public java_28061_CredentialValidator_A03(String username, String password) {
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