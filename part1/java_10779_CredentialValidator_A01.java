public class java_10779_CredentialValidator_A01 {

    public static boolean validate(UsernamePassword usernamePassword) {
        // A static array of usernames and passwords
        String[][] credentials = { {"admin", "password123"}, {"user", "password"} };

        // Validate the username and password
        for (int i = 0; i < credentials.length; i++) {
            if (credentials[i][0].equals(usernamePassword.getUsername()) 
                && credentials[i][1].equals(usernamePassword.getPassword())) {
                return true;
            }
        }

        return false;
    }

    // Data class to hold a username and password
    public static class UsernamePassword {
        private String username;
        private String password;

        public java_10779_CredentialValidator_A01(String username, String password) {
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

    public static void main(String[] args) {
        UsernamePassword user = new UsernamePassword("admin", "password123");
        boolean isValid = CredentialValidator.validate(user);
        System.out.println("Is valid? " + isValid); // Expected output: Is valid? true
    }
}