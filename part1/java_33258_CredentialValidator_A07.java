public class java_33258_CredentialValidator_A07 {

    // Static user data for testing
    private static final String USERNAME = "testuser";
    private static final String PASSWORD = "testpassword";

    // A07_AuthFailure example: Authentication failure is a serious security concern.
    // In this example, we're checking if the provided username and password match our
    // static data and, if they do, returning a user object. If they don't,
    // we're throwing an InvalidUserException.
    public User validate(String username, String password) {
        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            return new User(username);
        } else {
            throw new InvalidUserException("Invalid username or password.");
        }
    }

    // User class for testing
    public class User {
        private String username;

        public java_33258_CredentialValidator_A07(String username) {
            this.username = username;
        }

        public String getUsername() {
            return username;
        }
    }

    // InvalidUserException class for testing
    public class InvalidUserException extends RuntimeException {
        public java_33258_CredentialValidator_A07(String message) {
            super(message);
        }
    }
}