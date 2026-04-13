public class java_21906_CredentialValidator_A07 {
    private String username;
    private String password;

    // constructor, getters and setters here
}

public class Credentials {
    private String username;
    private String password;

    // constructor, getters and setters here
}

public class CredentialValidator {
    public boolean validateUser(Credentials credentials) {
        // here we are using a simple equality check. In a real-world application,
        // you would want to use a more secure method of storing passwords and comparing them.
        User user = retrieveUserByUsername(credentials.getUsername());

        if (user == null) {
            return false;
        }

        if (user.getPassword().equals(credentials.getPassword())) {
            return true;
        }

        return false;
    }

    private User retrieveUserByUsername(String username) {
        // here we are using a simple mock implementation. In a real-world application,
        // you would want to connect to a database to retrieve user details.
        return new User("test", "password");
    }
}