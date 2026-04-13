public class java_20487_CredentialValidator_A07 {

    // Sample users
    private static final User USER1 = new User("username1", "password1");
    private static final User USER2 = new User("username2", "password2");

    public static boolean validate(String username, String password) {
        if (USER1.getUsername().equals(username) && USER1.getPassword().equals(password)) {
            return true;
        } else if (USER2.getUsername().equals(username) && USER2.getPassword().equals(password)) {
            return true;
        } else {
            throw new AuthenticationFailureException("Authentication failed");
        }
    }

    private static class User {
        private String username;
        private String password;

        public java_20487_CredentialValidator_A07(String username, String password) {
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

    private static class AuthenticationFailureException extends RuntimeException {
        public java_20487_CredentialValidator_A07(String message) {
            super(message);
        }
    }
}