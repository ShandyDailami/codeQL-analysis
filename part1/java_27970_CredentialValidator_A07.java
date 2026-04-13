public class java_27970_CredentialValidator_A07 {

    // This is a list of credentials. It should be stored in a secure place such as a database.
    private static final List<String> AUTHORIZED_USERS = Arrays.asList("admin", "user1", "user2", "user3");
    private static final List<String> AUTHORIZED_PASSWORDS = Arrays.asList("password1", "password2", "password3");

    // This method performs authentication. It takes in a username and password, and returns true if the credentials are valid.
    public boolean validate(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        // We are using a simple equals operation, but in a real-world scenario, you should use a hashing algorithm
        // to compare passwords for security reasons.
        if (AUTHORIZED_USERS.contains(username) && AUTHORIZED_PASSWORDS.contains(password)) {
            return true;
        }

        return false;
    }
}